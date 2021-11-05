package datos;

import datos.ConectarDB.*;
import modelo.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    public String selectTodaLaAgenda = "SELECT * FROM restdb.agenda;";
    public String insertContacto = "INSERT INTO restdb.agenda (nombre, apellido, telefono, email, domicilio) VALUES (?,?,?,?,?);";
    public String updateMailContacto = "UPDATE restdb.agenda SET email = ? WHERE id = ?;";
    public String updateTelefonoContacto = "UPDATE restdb.agenda SET telefono = ? WHERE id = ?;";
    public String deleteConctacto = "DELETE FROM restdb.agenda WHERE id = ?;";

    public List<Persona> selectPersonas() {
        List<Persona> lista = new ArrayList();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConectarDB.establecerConexion();
            ps = connection.prepareStatement(selectTodaLaAgenda);
            rs = ps.executeQuery();

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setNombre(rs.getString(2));
                persona.setApellido(rs.getString(3));
                persona.setTelefono(rs.getString(4));
                persona.setMail(rs.getString(5));
                persona.setDomicilio(rs.getString(6));
                lista.add(persona);
            }
        } catch (SQLException sqlex) {
            System.out.println(sqlex);
        } finally {
            ConectarDB.cerrarConexion(connection);
            ConectarDB.cerrarResultSet(rs);
            ConectarDB.cerrarStatement(ps);
        }
        return lista;
    }

    public void nuevoContacto(Persona persona) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConectarDB.establecerConexion();
            ps = connection.prepareStatement(insertContacto);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getTelefono());
            ps.setString(4, persona.getMail());
            ps.setString(5, persona.getDomicilio());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } finally {
            ConectarDB.cerrarConexion(connection);
            ConectarDB.cerrarStatement(ps);
        }
    }

    public void modificarMailContacto(int id, String email) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConectarDB.establecerConexion();
            ps = connection.prepareStatement(updateMailContacto);
            ps.setString(1, email);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } finally {
            ConectarDB.cerrarConexion(connection);
            ConectarDB.cerrarStatement(ps);
        }
    }

    public void modificarTelefonoContacto(int id, String telefono) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConectarDB.establecerConexion();
            ps = connection.prepareStatement(updateTelefonoContacto);
            ps.setString(1, telefono);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } finally {
            ConectarDB.cerrarConexion(connection);
            ConectarDB.cerrarStatement(ps);
        }
    }

    public void borrarContacto(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConectarDB.establecerConexion();
            ps = connection.prepareStatement(deleteConctacto);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println(sqle);
        } finally {
            ConectarDB.cerrarConexion(connection);
            ConectarDB.cerrarStatement(ps);
        }
    }
}
