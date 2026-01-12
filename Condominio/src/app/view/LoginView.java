package app.view;
import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    public JTextField txtUser = new JTextField();
    public JPasswordField txtPass = new JPasswordField();
    public JButton btnLogin = new JButton("Login");

    public LoginView() {
        setTitle("Login");
        setSize(350,180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2,5,5));
        add(new JLabel("Usuario:")); add(txtUser);
        add(new JLabel("Contraseña:")); add(txtPass);
        add(new JLabel()); add(btnLogin);
    }
}
