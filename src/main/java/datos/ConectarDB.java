package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConectarDB {
    public static Connection establecerConexion() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + /*nombre base de datos*/ "restdb" + "?useSSL=false", /*user*/ "root", /*passwrd*/ "mysql");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("No pudo conectarse a la Base de Datos.");
            System.out.println("Razón: " + e);
        }

        return con;
    }

    public static void cerrarConexion(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

    public static void cerrarStatement(PreparedStatement p) {
        try {
            if (p != null) {
                p.close();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

    public static void cerrarResultSet(ResultSet r) {
        try {
            if (r != null) {
                r.close();
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

}
