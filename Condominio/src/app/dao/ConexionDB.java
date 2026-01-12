package app.dao;

import java.sql.*;

public class ConexionDB {
    private static final String URL = "jdbc:sqlite:database/condominio.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
