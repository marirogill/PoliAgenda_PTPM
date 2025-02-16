/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosRest;

import PersistenceHijos.Hijos;
import PersistenceVacunas.Vacunas;
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
@Path("persistencevacunas.vacunas")
public class VacunasFacadeREST extends AbstractFacade<Vacunas> {

    @PersistenceContext(unitName = "AgendaPediatricaNuevoPU")
    private EntityManager em;

    public VacunasFacadeREST() {
        super(Vacunas.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Vacunas entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Vacunas entity) {
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
    public Vacunas find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Vacunas> findAll() {
        return super.findAll();      
    }

    @GET
    //@Override
    @Path("listadovacunas/{idHijo}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Vacunas> findByHijo(@PathParam("idHijo") Integer idHijo) {
        
        em = getEntityManager();
        
        Hijos hijo = getEntityManager().find(Hijos.class, idHijo);
                
        TypedQuery<Vacunas> consultaVacunas = em.createNamedQuery("Vacunas.findByIdHijo", Vacunas.class);
        consultaVacunas.setParameter("idHijo", hijo);
        return consultaVacunas.getResultList();
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vacunas> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
