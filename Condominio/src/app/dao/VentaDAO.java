package app.dao;

import app.model.Venta;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VentaDAO {

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public List<Venta> getAllVentas(){
        List<Venta> list = new ArrayList<>();
        try(Connection conn = ConexionDB.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ventas")) {

            while(rs.next()){
                list.add(new Venta(
                    rs.getInt("id"),
                    rs.getInt("producto_id"),
                    rs.getInt("cantidad"),
                    LocalDateTime.parse(rs.getString("fecha"),df)
                ));
            }
        } catch(Exception e){ e.printStackTrace();}
        return list;
    }

    public void addVenta(Venta v){
        try(Connection conn = ConexionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ventas(producto_id,cantidad,fecha) VALUES(?,?,?)")) {
            ps.setInt(1,v.getProductoId());
            ps.setInt(2,v.getCantidad());
            ps.setString(3,v.getFecha().format(df));
            ps.executeUpdate();
        } catch(Exception e){ e.printStackTrace();}
    }
}
