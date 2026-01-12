package app.model;

import java.time.LocalDateTime;

public class Venta {
    private int id;
    private int productoId;
    private int cantidad;
    private LocalDateTime fecha;

    public Venta(int id, int productoId, int cantidad, LocalDateTime fecha){
        this.id = id; this.productoId = productoId; this.cantidad = cantidad; this.fecha = fecha;
    }

    public int getId() { return id; }
    public int getProductoId() { return productoId; }
    public int getCantidad() { return cantidad; }
    public LocalDateTime getFecha() { return fecha; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
