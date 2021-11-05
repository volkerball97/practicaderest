package apprest;

import com.google.gson.Gson;
import control.ControladorPersona;
import datos.PersonaDAO;
import modelo.Persona;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("agenda")
public class AgendaRest {

    @GET
    @Path("/agendacompleta")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> mostrarAgenda() {
        ControladorPersona control = new ControladorPersona();
        return control.listaContactos();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> nuevoContacto(@FormParam("nombre") String nombre, @FormParam("apellido") String apellido,
                                       @FormParam("telefono") String telefono, @FormParam("domicilio") String domicilio,
                                       @FormParam("email") String email) {
        ControladorPersona control = new ControladorPersona();
        Persona personaNueva = new Persona();

        personaNueva.setDomicilio(domicilio);
        personaNueva.setMail(email);
        personaNueva.setTelefono(telefono);
        personaNueva.setApellido(apellido);
        personaNueva.setNombre(nombre);
        control.nuevoContacto(personaNueva);
        return control.listaContactos();
    }

    @PUT
    @Path("/modificaremail/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> modificarMail(@FormParam("email") String email, @PathParam("id") int id) {

        ControladorPersona control = new ControladorPersona();
        control.modificarEmail(id, email);
        return control.listaContactos();
    }

    @PUT
    @Path("/modificartelefono/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> modificarTelefono(@FormParam("telefono") String telefono, @PathParam("id") int id) {
        ControladorPersona control = new ControladorPersona();
        control.modificarTelefono(id, telefono);
        return control.listaContactos();
    }

    @DELETE
    @Path("/borrarcontacto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> borrarContacto(@PathParam("id") int id) {
        ControladorPersona control = new ControladorPersona();
        control.borrarContacto(id);
        return control.listaContactos();
    }
}
