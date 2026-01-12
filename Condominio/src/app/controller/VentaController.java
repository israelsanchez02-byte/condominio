package app.controller;

import app.dao.VentaDAO;
import app.dao.ProductoDAO;
import app.model.Venta;
import app.model.Producto;
import app.view.VentaView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VentaController {
    private VentaView view;
    private VentaDAO dao;
    private ProductoDAO pdao;

    public VentaController(VentaView v) {
        this.view = v; this.dao = new VentaDAO(); this.pdao = new ProductoDAO();
        init();
    }

    private void init() {
        cargarTabla();
        view.btnRefrescar.addActionListener(e -> cargarTabla());
        view.btnNueva.addActionListener(e -> nuevaVenta());
    }

    private void cargarTabla() {
        List<Venta> list = dao.all();
        String[] cols = {"ID","ProductoId","Cantidad","Total","Fecha"};
        DefaultTableModel m = new DefaultTableModel(cols,0) { public boolean isCellEditable(int r,int c){return false;} };
        for (Venta v : list) m.addRow(new Object[]{v.getId(), v.getProductoId(), v.getCantidad(), v.getTotal(), v.getFecha()});
        view.tabla.setModel(m);
    }

    private void nuevaVenta() {
        List<Producto> prod = pdao.all();
        if (prod.isEmpty()) { JOptionPane.showMessageDialog(view,"No hay productos"); return; }
        String[] nombres = prod.stream().map(Producto::getNombre).toArray(String[]::new);
        JComboBox<String> cb = new JComboBox<>(nombres);
        JTextField cantidad = new JTextField("1");
        Object[] msg = {"Producto:", cb, "Cantidad:", cantidad};
        int opt = JOptionPane.showConfirmDialog(view, msg, "Nueva venta", JOptionPane.OK_CANCEL_OPTION);
        if (opt==JOptionPane.OK_OPTION) {
            try {
                int idx = cb.getSelectedIndex();
                Producto p = prod.get(idx);
                int cant = Integer.parseInt(cantidad.getText());
                double total = p.getPrecio() * cant;
                Venta v = new Venta(p.getId(), cant, total);
                dao.insert(v);
                // actualizar stock (opcional)
                cargarTabla();
                JOptionPane.showMessageDialog(view, "Venta registrada. Total: " + total);
            } catch (Exception ex) { JOptionPane.showMessageDialog(view,"Datos inválidos"); }
        }
    }
}
