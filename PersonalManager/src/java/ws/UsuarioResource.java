/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import models.Usuario;
import repositorio.RepositorioProfessor;

/**
 * REST Web Service
 *
 * @author Ricardo
 */
@Path("usuario")
public class UsuarioResource {

    @Context
    private UriInfo context;
    
    @EJB
    RepositorioProfessor repositorio;

    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
        repositorio = new RepositorioProfessor();
    }

    /**
     * Retrieves representation of an instance of ws.UsuarioResource
     * @return an instance of model.Usuario
     */
    @GET
    @Produces("application/json")
    public List<Usuario> getUsuarios() {
        //TODO return proper representation object
        return repositorio.getProfessores();
    }

    /**
     * PUT method for updating or creating an instance of UsuarioResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public String addUsuario(Usuario usuario) {
        repositorio.adicionar(usuario);
        return "OK";
    }
}
