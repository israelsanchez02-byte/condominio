package app.dao;

import app.model.Producto;
import java.sql.*;
import java.util.*;

public class ProductoDAO {

    public List<Producto> getAllProductos() {
        List<Producto> list = new ArrayList<>();
        try(Connection conn = ConexionDB.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM productos")) {

            while(rs.next()){
                list.add(new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                ));
            }
        } catch(Exception e){ e.printStackTrace();}
        return list;
    }

    public void addProducto(Producto p){
        try(Connection conn = ConexionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO productos(nombre,descripcion,precio,stock) VALUES(?,?,?,?)")) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());
            ps.executeUpdate();
        } catch(Exception e){ e.printStackTrace();}
    }

    public void updateProducto(Producto p){
        try(Connection conn = ConexionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE productos SET nombre=?,descripcion=?,precio=?,stock=? WHERE id=?")) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getStock());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        } catch(Exception e){ e.printStackTrace();}
    }

    public void deleteProducto(int id){
        try(Connection conn = ConexionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM productos WHERE id=?")) {
            ps.setInt(1,id); ps.executeUpdate();
        } catch(Exception e){ e.printStackTrace();}
    }
}
