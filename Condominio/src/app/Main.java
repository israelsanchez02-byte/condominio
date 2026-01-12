package app;

import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;
import app.view.LoginView;
import app.controller.LoginController;


public class Main {
    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(new FlatLightLaf()); } 
        catch (Exception e) { e.printStackTrace(); }

        SwingUtilities.invokeLater(() -> {
            LoginView login = new LoginView();
            new LoginController(login);
            login.setVisible(true);
        });
    }
}
