package app.controller;

import app.view.*;
import app.controller.*;
import app.dao.*;
import app.service.ExportService;

import javax.swing.*;
import java.awt.*;

public class DashboardController {
    private MainDashboardView main;
    private ProductoView productoView;
    private VentaView ventaView;
    private ProductoController productoController;
    private VentaController ventaController;

    public DashboardController(MainDashboardView main) {
        this.main = main;
        productoView = new ProductoView();
        ventaView = new VentaView();
        productoController = new ProductoController(productoView);
        ventaController = new VentaController(ventaView);

        // inicializar acciones del dashboard
        main.btnProductos.addActionListener(e -> showPanel(productoView));
        main.btnVentas.addActionListener(e -> showPanel(ventaView));
        main.btnExportarPDF.addActionListener(e -> exportCurrentAsPDF());
        main.btnExportarExcel.addActionListener(e -> exportCurrentAsExcel());
        showPanel(productoView);
    }

    private void showPanel(JPanel panel) {
        main.contentPanel.removeAll();
        main.contentPanel.add(panel, BorderLayout.CENTER);
        main.contentPanel.revalidate();
        main.contentPanel.repaint();
    }

    private void exportCurrentAsPDF() {
        Component c = main.contentPanel.getComponentCount() > 0 ? main.contentPanel.getComponent(0) : null;
        if (c instanceof ProductoView) {
            JTable t = ((ProductoView)c).tabla;
            try {
                String ruta = "productos_reporte.pdf";
                ExportService.exportarPDF(t,ruta,"Reporte Productos");
                JOptionPane.showMessageDialog(main,"PDF generado: "+ruta);
            } catch (Exception ex){ JOptionPane.showMessageDialog(main,"Error: "+ex.getMessage()); }
        } else if (c instanceof VentaView) {
            JTable t = ((VentaView)c).tabla;
            try {
                String ruta = "ventas_reporte.pdf";
                ExportService.exportarPDF(t,ruta,"Reporte Ventas");
                JOptionPane.showMessageDialog(main,"PDF generado: "+ruta);
            } catch (Exception ex){ JOptionPane.showMessageDialog(main,"Error: "+ex.getMessage()); }
        }
    }

    private void exportCurrentAsExcel() {
        Component c = main.contentPanel.getComponentCount() > 0 ? main.contentPanel.getComponent(0) : null;
        if (c instanceof ProductoView) {
            JTable t = ((ProductoView)c).tabla;
            try {
                String ruta = "productos_reporte.xlsx";
                ExportService.exportarExcel(t,ruta);
                JOptionPane.showMessageDialog(main,"Excel generado: "+ruta);
            } catch (Exception ex){ JOptionPane.showMessageDialog(main,"Error: "+ex.getMessage()); }
        } else if (c instanceof VentaView) {
            JTable t = ((VentaView)c).tabla;
            try {
                String ruta = "ventas_reporte.xlsx";
                ExportService.exportarExcel(t,ruta);
                JOptionPane.showMessageDialog(main,"Excel generado: "+ruta);
            } catch (Exception ex){ JOptionPane.showMessageDialog(main,"Error: "+ex.getMessage()); }
        }
    }
}
