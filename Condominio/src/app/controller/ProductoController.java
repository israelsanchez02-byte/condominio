package app.controller;

import app.dao.ProductoDAO;
import app.model.Producto;
import app.view.ProductoView;
import app.service.ExportService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class ProductoController {
    private ProductoView view;
    private ProductoDAO dao;

    public ProductoController(ProductoView v) {
        this.view = v; this.dao = new ProductoDAO();
        init();
    }

    private void init() {
        cargarTabla();
        view.btnRefrescar.addActionListener(e -> cargarTabla());
        view.btnNuevo.addActionListener(e -> mostrarDialogoNuevo());
        view.btnBorrar.addActionListener(e -> eliminarSeleccion());
        view.btnEditar.addActionListener(e -> editarSeleccion());
    }

    private void cargarTabla() {
        List<Producto> list = dao.all();
        String[] cols = {"ID","Nombre","Descripcion","Precio","Stock"};
        DefaultTableModel m = new DefaultTableModel(cols,0) {
            public boolean isCellEditable(int r,int c){return false;}
        };
        for (Producto p : list) m.addRow(new Object[]{p.getId(),p.getNombre(),p.getDescripcion(),p.getPrecio(),p.getStock()});
        view.tabla.setModel(m);
    }

    private void mostrarDialogoNuevo() {
        JTextField nombre = new JTextField(), desc = new JTextField(), precio = new JTextField(), stock = new JTextField();
        Object[] msg = {"Nombre:",nombre,"Descripcion:",desc,"Precio:",precio,"Stock:",stock};
        int opt = JOptionPane.showConfirmDialog(view,msg,"Nuevo producto",JOptionPane.OK_CANCEL_OPTION);
        if (opt==JOptionPane.OK_OPTION) {
            try {
                Producto p = new Producto(nombre.getText(),desc.getText(),Double.parseDouble(precio.getText()), Integer.parseInt(stock.getText()));
                dao.insert(p); cargarTabla();
            } catch (Exception ex){ JOptionPane.showMessageDialog(view,"Datos inválidos"); }
        }
    }

    private void eliminarSeleccion() {
        int r = view.tabla.getSelectedRow();
        if (r < 0) { JOptionPane.showMessageDialog(view,"Selecciona un producto"); return; }
        int id = Integer.parseInt(view.tabla.getValueAt(r,0).toString());
        if (JOptionPane.showConfirmDialog(view,"Seguro borrar?","Confirmar",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION) return;
        dao.delete(id); cargarTabla();
    }

    private void editarSeleccion() {
        int r = view.tabla.getSelectedRow();
        if (r < 0) { JOptionPane.showMessageDialog(view,"Selecciona un producto"); return; }
        int id = Integer.parseInt(view.tabla.getValueAt(r,0).toString());
        Producto p = dao.all().stream().filter(x->x.getId()==id).findFirst().orElse(null);
        if (p==null) return;
        JTextField nombre = new JTextField(p.getNombre()), desc = new JTextField(p.getDescripcion());
        JTextField precio = new JTextField(String.valueOf(p.getPrecio())), stock = new JTextField(String.valueOf(p.getStock()));
        Object[] msg = {"Nombre:",nombre,"Descripcion:",desc,"Precio:",precio,"Stock:",stock};
        int opt = JOptionPane.showConfirmDialog(view,msg,"Editar producto",JOptionPane.OK_CANCEL_OPTION);
        if (opt==JOptionPane.OK_OPTION) {
            try {
                p.setNombre(nombre.getText()); p.setDescripcion(desc.getText());
                p.setPrecio(Double.parseDouble(precio.getText())); p.setStock(Integer.parseInt(stock.getText()));
                dao.update(p); cargarTabla();
            } catch (Exception ex){ JOptionPane.showMessageDialog(view,"Datos inválidos"); }
        }
    }
}
