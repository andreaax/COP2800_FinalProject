import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.Locale;

public class LibraryGUI{
    private JButton button_signIn;
    private JPanel panelHome;
    private JPanel signIn;
    private JLabel label_title;
    private JPasswordField passwordField1;
    private JTextField emailTxt;
    private JButton signUpButton;

    private DatabaseHelper databaseHelper = new DatabaseHelper();
    public JPanel getPanel() {
        return panelHome;
    }

    public LibraryGUI() {
        button_signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if (e.getSource()==button_signIn) {
                //     signIn myWindow = new signIn();
                // }

                if(databaseHelper.VerifyUserCreds(emailTxt.getText(), String.valueOf(passwordField1.getPassword()))){
                    Component component = (Component) e.getSource();
                    JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                    frame.setContentPane(new LibraryContentGUI(databaseHelper).getPanel());
                    frame.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Sign in");
                }

            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                frame.setContentPane(new RegisterGUI(databaseHelper).getPanel());
                frame.setVisible(true);
            }
        });

        panelHome.addComponentListener(new ComponentAdapter() {
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hurtado Library");
        frame.setContentPane(new LibraryGUI().panelHome);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLayout(null);
        frame.setVisible(true);
    }

    /*
    public static class signIn {

        JFrame frame = new JFrame("Sign in");

        signIn(){

            frame.setContentPane(new LibraryGUI().signIn);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.setVisible(true);
        }

     */
    //}
}
