import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryContentGUI {
    private JPanel panel_librarycontent;
    private JTextField textField1;
    private JButton searchButton;
    private JButton classicsButton;
    private JButton mysteryButton;
    private JButton romanceButton;
    private JButton fictionButton;
    private JButton historyButton;
    private JButton horrorButton;

    public LibraryContentGUI(DatabaseHelper databaseHelper){
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                BookDisplay bookDisplay =new BookDisplay(databaseHelper, textField1.getText());
                bookDisplay.RenderDataSearch(textField1.getText());
                frame.setContentPane(bookDisplay.getPanel());
                frame.setVisible(true);
            }
        });

        classicsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                frame.setContentPane(new BookDisplay(databaseHelper, "Classics").getPanel());
                frame.setVisible(true);
            }
        });

        mysteryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                frame.setContentPane(new BookDisplay(databaseHelper, "Mystery").getPanel());
                frame.setVisible(true);
            }
        });

        romanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                frame.setContentPane(new BookDisplay(databaseHelper, "Romance").getPanel());
                frame.setVisible(true);
            }
        });

        fictionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                frame.setContentPane(new BookDisplay(databaseHelper, "Fiction").getPanel());
                frame.setVisible(true);
            }
        });

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                frame.setContentPane(new BookDisplay(databaseHelper, "History").getPanel());
                frame.setVisible(true);
            }
        });

        horrorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                frame.setContentPane(new BookDisplay(databaseHelper, "Horror").getPanel());
                frame.setVisible(true);
            }
        });
    }
    public JPanel getPanel(){
        return panel_librarycontent;
    }
}
