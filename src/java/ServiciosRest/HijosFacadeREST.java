/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosRest;

import PersistenceHijos.Hijos;
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
@Path("persistencehijos.hijos")
public class HijosFacadeREST extends AbstractFacade<Hijos> {

    @PersistenceContext(unitName = "AgendaPediatricaNuevoPU")
    private EntityManager em;

    public HijosFacadeREST() {
        super(Hijos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Hijos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Hijos entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Hijos find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    
   
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Hijos> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("listadohijos/{idPadre}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Hijos> findByUsuario(@PathParam("idPadre") Integer idPadre) {
        
        em = getEntityManager();
                
        TypedQuery<Hijos> consultaHijos = em.createNamedQuery("Hijos.findByUsuario", Hijos.class);
        consultaHijos.setParameter("idUsuario", idPadre);
        return consultaHijos.getResultList();
    }
    

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Hijos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        //return em;
        return em = Persistence.createEntityManagerFactory("AgendaPediatricaNuevoPU").createEntityManager();
    }
    
}
