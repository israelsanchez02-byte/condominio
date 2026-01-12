package app.view;

import javax.swing.*;
import java.awt.*;

public class MainDashboardView extends JFrame {
    public JButton btnProductos = new JButton("Productos");
    public JButton btnVentas = new JButton("Ventas");
    public JButton btnPDF = new JButton("Exportar PDF");
    public JButton btnExcel = new JButton("Exportar Excel");
    public JTabbedPane tabbedPane = new JTabbedPane();
    public String rol;

    public MainDashboardView(String rol){
        this.rol = rol;
        setTitle("Dashboard - Rol: "+rol);
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.add(btnProductos);
        top.add(btnVentas);
        if(rol.equals("ADMIN")) { top.add(btnPDF); top.add(btnExcel); }
        add(top,BorderLayout.NORTH);
        add(tabbedPane,BorderLayout.CENTER);
    }
}
