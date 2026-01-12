package app.view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentaView extends JPanel{
    public JTable table = new JTable();
    public DefaultTableModel model;
    public JTextField txtBuscar = new JTextField(15);

    public VentaView(){
        setLayout(new BorderLayout());
        model = new DefaultTableModel(new String[]{"ID","ProductoID","Cantidad","Fecha"},0){
            public boolean isCellEditable(int row,int col){ return false; }
        };
        table.setModel(model);

        JPanel top = new JPanel();
        top.add(new JLabel("Buscar:"));
        top.add(txtBuscar);
        add(top,BorderLayout.NORTH);
        add(new JScrollPane(table),BorderLayout.CENTER);
    }
}
