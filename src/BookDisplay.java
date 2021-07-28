import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class BookDisplay {
    private JTable table1;
    private JPanel Panel;
    private JButton goBackButton;
    private JButton checkout;

    private String result;
    private DatabaseHelper databaseHelper;
    private Hashtable<String,String> isbnList;

    public BookDisplay(DatabaseHelper databaseHelper, String result){
        this.result = result;
        this.databaseHelper = databaseHelper;
        createTable();
        RenderData();
        getSelection();

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                frame.setContentPane(new LibraryContentGUI(databaseHelper).getPanel());
                frame.setVisible(true);
            }
        });

        checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JList list = new JList(isbnList.values().toArray());
               JOptionPane optionPane = new JOptionPane();
                JButton okButton = new JButton("Ok");


                optionPane.showMessageDialog(null, list,"Checkout Book List", JOptionPane.INFORMATION_MESSAGE);
                optionPane.add(okButton);

                Enumeration<String> element = isbnList.keys();

                while (element.hasMoreElements()) {

                    // Getting the key of a particular entry
                    String key = element.nextElement();
                    databaseHelper.UpdateBookAvailability(key);
                }
            }
        });
    }

    public JPanel getPanel() {
        return Panel;
    }

    private void createTable(){
        table1.setModel(new DefaultTableModel(null,
                new String[]{"ISBN", "Title", "Author", "Genre", "Available"}));
    }
    private void RenderData(){
        ArrayList<Books> booksList = new ArrayList<Books>();
        booksList = databaseHelper.SearchBookByGenre(result);

        int i = 0;
        while(i < booksList.size())
        {
            Books books = booksList.get(i);
            String data [] = {String.valueOf(books.isbn),books.title, books.author, books.genre, books.isAvailable == true ? "Yes": "No"};

            DefaultTableModel tbl = (DefaultTableModel) table1.getModel();
            tbl.addRow(data);

            i++;
        }
    }

    public void RenderDataSearch(String search){
        ArrayList<Books> booksList = new ArrayList<Books>();
        booksList = databaseHelper.SearchBookByKeyword(result);

        int i = 0;
        while(i < booksList.size())
        {
            Books books = booksList.get(i);
            String data [] = {String.valueOf(books.isbn),books.title, books.author, books.genre, books.isAvailable == true ? "Yes": "No"};

            DefaultTableModel tbl = (DefaultTableModel) table1.getModel();
            tbl.addRow(data);

            i++;
        }
    }

    private void getSelection()
    {
        ListSelectionModel listSelectionModel = table1.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                isbnList = new Hashtable<String, String>();

                int [] rowSelected = table1.getSelectedRows();
                for(int i = 0; i < rowSelected.length; i++)
                {
                    if(table1.getValueAt(rowSelected[i],4).toString().equals("Yes"));
                        isbnList.put(table1.getValueAt(rowSelected[i], 0).toString(), table1.getValueAt(rowSelected[i],1).toString());
                }

             }
        });

    }
}
