/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosRest;

import PersistenceUsuario.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author pablo
 */
//@Stateless
@Path("persistenceusuario.usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "AgendaPediatricaNuevoPU")
    private EntityManager em;
    
    private JsonObject correoUsuario;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Usuario entity) {
        super.create(entity);
    }
    
    /*Servicio POST donde verificamos si el correo del usuario logeado con google
    ya existe en nuestra base de datos.*/
    @POST
    @Path("validar")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> ValidarUsuario(JsonObject JObject) {
        //super.create(JsonObject);
        List<Usuario> result = null;

        if((JObject.size()) > 0){
            String usuCorreo = JObject.getAsJsonObject().get("correo").getAsString();
            result = buscarCorreo(usuCorreo);
        }

        return result;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("usuario/{correo}")
    @Produces({MediaType.APPLICATION_JSON})
    public Usuario findByCorreo(@PathParam("correo") String correo) {
        
        em = getEntityManager();
        
        TypedQuery<Usuario> consultaUsuario = em.createNamedQuery("Usuario.findByCorreo", Usuario.class);
        consultaUsuario.setParameter("correo", correo);
        List<Usuario> usulist = consultaUsuario.getResultList();
        
        //return consultaUsuario.getResultList();
        //RETORNAMOS el primer valor del arraylist, suponiendo que siempre traerá un solo valor.
        return usulist.get(0);

    }
    
    /*
    @GET
    @Path("usuario/{correo}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> findByCorreo(@PathParam("correo") String correo) {
        
        em = getEntityManager();
        
        TypedQuery<Usuario> consultaUsuario = em.createNamedQuery("Usuario.findByCorreo", Usuario.class);
        consultaUsuario.setParameter("correo", correo);
        return consultaUsuario.getResultList();
    }
    */

    @Override
    protected EntityManager getEntityManager() {
        //return em;
         return em = Persistence.createEntityManagerFactory("AgendaPediatricaNuevoPU").createEntityManager();
    }

    //Función donde buscamos al usuario por correo.
    //dicho correo es el parámetro ingresado para localizarlo por el typedquery creado
    //en la persistencia.
    private List<Usuario> buscarCorreo(String correo) {
        TypedQuery<Usuario> consultaUsuario = em.createNamedQuery("Usuario.findByCorreo", Usuario.class);
        consultaUsuario.setParameter("correo", correo);
        return consultaUsuario.getResultList();
    }
    
}
