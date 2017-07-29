/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Categoria;
import com.model.Persona;
import java.util.List;
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
@Path("com.model.categoria")
public class CategoriaFacadeREST extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "PROYECTO_FINALPU")
    private EntityManager em;

    public CategoriaFacadeREST() {
        super(Categoria.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Categoria entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Categoria entity) {
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
    public Categoria find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categoria> findAll() {
        return null;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categoria> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public String crear(@FormParam("pkCategoria")String pkCategoria,@FormParam("nombre")String nombre,@FormParam("eliminado")boolean eliminado){
        String mensaje="{\"exitoso\":false}";
        try{
            create(new Categoria(pkCategoria, nombre, eliminado));
            mensaje="{\"exitoso\":true}";
            
        }catch(Exception ex){      
        }
        return mensaje;
    }
//    public Persona crear1(String pkPersona, String nombre, String apellido, String direccion, String correo, String telefono, String ciudad, boolean eliminado){
//        Persona e= null;
//        TypedQuery<Persona>qry;
//        qry=getEntityManager().createQuery("SELECT p FROM Persona p WHERE p.pkPersona = :pkPersona, p.nombre = :nombre, p.apellido = :apellido, p.direccion = :direccion,p.correo = :correo, p.telefono = :telefono, p.ciudad = :ciudad, p.eliminado = :eliminado ", Persona.class);
//        qry.setParameter("pkPersona", pkPersona);
//        qry.setParameter("nombre", nombre);
//        qry.setParameter("apellido", apellido);
//        qry.setParameter("direccion", direccion);
//        qry.setParameter("correo", correo);
//        qry.setParameter("telefono", telefono);
//        qry.setParameter("ciudad", ciudad);
//        qry.setParameter("eliminado", eliminado);
//        try { 
//            return qry.getSingleResult();
//        } catch (NoResultException ex) {
//            return null;
//        }
//    }
    
    @POST
    @Path("consulta")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Categoria> consulta(@FormParam("pkCategoria") String pkCategoria) {
         List<Categoria> retorno=obtenersaldo(pkCategoria);
         return retorno;
    }
            
    public List<Categoria> obtenersaldo(String valor) {
        TypedQuery<Categoria> qry;
        qry = getEntityManager().createQuery("SELECT c FROM Categoria c WHERE c.pkCategoria = :pkCategoria ",Categoria.class);
        qry.setParameter("pkCategoria", valor);
        try {
            return qry.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("pkCategoria")String pkCategoria,@FormParam("nombre")String nombre,@FormParam("eliminado")boolean eliminado){
        String mensaje="{\"exitoso\":false,\"motivo\":";
        Categoria e=BuscarPorId(pkCategoria);
        
        if (e!=null){
            if (!(pkCategoria.equals(""))|| (nombre.equals(""))){
               e.setPkCategoria(pkCategoria);
               e.setNombre(nombre);
    
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
    public String eliminar(@FormParam ("pkCategoria")String pkCategoria){
        String mensaje="{\"exitoso\":false,\"motivo\":";
        Categoria e=BuscarPorId(pkCategoria);
        
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
    
    public Categoria BuscarPorId(String pkCategoria){
        Categoria p = null;
        TypedQuery<Categoria>qry;
        qry=getEntityManager().createQuery("SELECT c FROM Categoria c WHERE c.pkCategoria = :pkCategoria and c.eliminado = :eliminado", Categoria.class);
        qry.setParameter("pkCategoria", pkCategoria);
        qry.setParameter("eliminado", false);

        try {
            return qry.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
