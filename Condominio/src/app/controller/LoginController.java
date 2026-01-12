package app.controller;
import app.view.LoginView;
import javax.swing.*;
import java.sql.*;
import app.view.MainDashboardView;

public class LoginController {
    private LoginView view;
    public LoginController(LoginView v){ 
        this.view = v;
        view.btnLogin.addActionListener(e -> login());
    }

    private void login() {
        String user = view.txtUser.getText();
        String pass = new String(view.txtPass.getPassword());
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:database/condominio.db")) {
            PreparedStatement ps = conn.prepareStatement("SELECT rol FROM usuarios WHERE username=? AND password=?");
            ps.setString(1,user); ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String rol = rs.getString("rol");
                JOptionPane.showMessageDialog(view,"Bienvenido "+rol);
                view.dispose();
                MainDashboardView dashboard = new MainDashboardView(rol);
                dashboard.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(view,"Usuario o contraseña incorrectos");
            }
        } catch(Exception e){ e.printStackTrace();}
    }
}
