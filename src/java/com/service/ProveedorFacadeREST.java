/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Persona;
import com.model.Proveedor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Kevin
 */
@Stateless
@Path("com.model.proveedor")
public class ProveedorFacadeREST extends AbstractFacade<Proveedor> {

    @EJB
    PersonaFacadeREST personaFacadeREST;
    
    @PersistenceContext(unitName = "PROYECTO_FINALPU")
    private EntityManager em;

    public ProveedorFacadeREST() {
        super(Proveedor.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Proveedor entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Proveedor entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Proveedor find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Proveedor> findAll() {
        return null;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Proveedor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
        return em;
    }
    
    @POST
    @Path("Crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("pkProveedor")String pkProveedor,@FormParam("nombreProveedor")String nombreProveedor,@FormParam("eliminado") boolean eliminado,@FormParam("pERSONApkpersona")String pERSONApkpersona){
        String mensaje="{\"exitoso\":false}";
        Persona per=personaFacadeREST.find(pERSONApkpersona);  
        try{
                create(new Proveedor(pkProveedor,nombreProveedor,eliminado,per));
                mensaje="{\"exitoso\":true}";
             
        }catch(Exception ex){      
        }
        return mensaje;
    }
//    public Proveedor crear1(String pkProveedor, String nombreProveedor, boolean eliminado){
//        Proveedor e= null;
//        TypedQuery<Proveedor>qry;
//        qry=getEntityManager().createQuery("SELECT p FROM Proveedor p WHERE p.pkProveedor = :pkProveedor, p.nombreProveedor = :nombreProveedor,p.eliminado = :eliminado", Proveedor.class);
//        qry.setParameter("pkProveedor", pkProveedor);
//        qry.setParameter("nombreProveedor", nombreProveedor);
//        qry.setParameter("eliminado",eliminado);
//       
//        try {
//            return qry.getSingleResult();
//        } catch (NoResultException ex) {
//            return null;
//        }
//    }
    @POST
    @Path("consulta")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Proveedor> consulta(@FormParam("pkProveedor") String pkProveedor) {
         List<Proveedor> retorno=obtenersaldo(pkProveedor);
         return retorno;
    }
            
    public List<Proveedor> obtenersaldo(String valor) {
        TypedQuery<Proveedor> qry;
        qry = getEntityManager().createQuery("SELECT p FROM Proveedor p WHERE p.pkProveedor = :pkProveedor ",Proveedor.class);
        qry.setParameter("pkProveedor", valor);
        try {
            return qry.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("pkProveedor")String pkProveedor, @FormParam("nombreProveedor")String nombreProveedor,@FormParam("eliminado")boolean eliminado, @FormParam("pERSONApkpersona")String pERSONApkpersona){
        String mensaje="{\"exitoso\":false,\"motivo\":";
        Proveedor e=BuscarPorId(pkProveedor);
        Persona per=personaFacadeREST.find(pERSONApkpersona);  

        if (e!=null){
            if (!(pkProveedor.equals("")) || (nombreProveedor.equals("")) || (pERSONApkpersona.equals("")) ){
               e.setPkProveedor(pkProveedor);
               e.setNombreProveedor(nombreProveedor);
               e.setEliminado(eliminado);
               e.setPERSONApkpersona(per);
               
                try{
                    edit(e);
                    mensaje="{\"exitoso\":true";
                }catch(Exception ex){
                    mensaje+="\"Excepcion en base\"";
                } 
            }else{
            mensaje+="\"Datos no correctoss\"";
        }
              
        }else{
            mensaje+="\"Datos no correctos\"";
        }
        
        mensaje+="}";
        return mensaje;
    }
 
    @POST
    @Path("eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String eliminar(@FormParam ("pkProveedor")String pkProveedor){
        String mensaje="{\"exitoso\":false,\"motivo\":";
        Proveedor e=BuscarPorId(pkProveedor);
        
        if (e!=null){
            e.setEliminado(true);
            edit(e);
            mensaje="{\"exitoso\":true";
        }else{
            mensaje+="\"Datos no correctos\"";
        }
        mensaje+="}";
        return mensaje;
    }
    
    public Proveedor BuscarPorId(String pkProveedor){
        Proveedor p = null;
        TypedQuery<Proveedor>qry;
        qry=getEntityManager().createQuery("SELECT p FROM Proveedor p WHERE p.pkProveedor = :pkProveedor and p.eliminado = :eliminado", Proveedor.class);
        qry.setParameter("pkProveedor", pkProveedor);
        qry.setParameter("eliminado", false);

        try {
            return qry.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
