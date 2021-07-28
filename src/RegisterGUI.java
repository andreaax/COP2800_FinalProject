import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterGUI{
    private JPanel PanelRegister;
    private JLabel label_register;
    private JTextField fNameTxt;
    private JTextField lNameTxt;
    private JTextField emailTxt;
    private JTextField phoneTxt;
    private JTextField addressTxt;
    private JTextField cardNumberTxt;
    private JButton button_cancel;
    private JButton button_save;
    private JPasswordField passwordField1;


    public JPanel getPanel(){
        return PanelRegister;
    }

    public RegisterGUI(DatabaseHelper helper){
        button_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helper.SaveRegistration(fNameTxt.getText(), lNameTxt.getText(), emailTxt.getText(), addressTxt.getText(), phoneTxt.getText(), cardNumberTxt.getText(), passwordField1.getText());
                Component component = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                frame.setContentPane(new LibraryGUI().getPanel());
                frame.setVisible(true);
            }
        });

        button_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                frame.setContentPane(new LibraryGUI().getPanel());
                frame.setVisible(true);
            }
        });
    }
}
