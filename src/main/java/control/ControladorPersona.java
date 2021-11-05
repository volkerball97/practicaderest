package control;

import datos.PersonaDAO;
import modelo.Persona;

import java.util.List;

public class ControladorPersona {
    PersonaDAO personaDAO = new PersonaDAO();

    public List<Persona> listaContactos() {
        return personaDAO.selectPersonas();
    }

    public void nuevoContacto(Persona persona) {
        personaDAO.nuevoContacto(persona);
    }

    public void modificarEmail(int id, String email) {
        personaDAO.modificarMailContacto(id, email);
    }

    public void modificarTelefono(int id, String telefono) {
        personaDAO.modificarTelefonoContacto(id, telefono);
    }

    public void borrarContacto(int id) {
        personaDAO.borrarContacto(id);
    }
}
