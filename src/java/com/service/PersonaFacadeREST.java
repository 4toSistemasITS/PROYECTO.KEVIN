/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

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
@Path("com.model.persona")
public class PersonaFacadeREST extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "PROYECTO_FINALPU")
    private EntityManager em;

    public PersonaFacadeREST() {
        super(Persona.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Persona entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Persona entity) {
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
    public Persona find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> findAll() {
        return null;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public String crear(@FormParam("pkPersona")String pkPersona,@FormParam("nombre")String nombre,@FormParam("apellido")String apellido, @FormParam("direccion")String direccion, @FormParam("correo")String correo,@FormParam("telefono")String telefono, @FormParam("ciudad")String ciudad,@FormParam("eliminado")boolean eliminado){
        String mensaje="{\"exitoso\":false}";
        try{
            create(new Persona(pkPersona, nombre, apellido, direccion, correo, telefono, ciudad, eliminado));
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
    public List<Persona> consulta(@FormParam("pkPersona") String pkPersona) {
         List<Persona> retorno=obtenersaldo(pkPersona);
         return retorno;
    }
            
    public List<Persona> obtenersaldo(String valor) {
        TypedQuery<Persona> qry;
        qry = getEntityManager().createQuery("SELECT p FROM Persona p WHERE p.pkPersona = :pkPersona ",Persona.class);
        qry.setParameter("pkPersona", valor);
        try {
            return qry.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("pkPersona")String pkPersona,@FormParam("nombre")String nombre,@FormParam("apellido")String apellido, @FormParam("direccion")String direccion, @FormParam("correo")String correo,@FormParam("telefono")String telefono, @FormParam("ciudad")String ciudad,@FormParam("eliminado")boolean eliminado){
        String mensaje="{\"exitoso\":false,\"motivo\":";
        Persona e=BuscarPorId(pkPersona);
        
        if (e!=null){
            if (!(pkPersona.equals(""))|| (nombre.equals(""))||(apellido.equals(""))||(direccion.equals(""))||(correo.equals(""))||(telefono.equals(""))||(ciudad.equals("")) ){
               e.setPkPersona(pkPersona);
               e.setNombre(nombre);
               e.setApellido(apellido);
               e.setDireccion(direccion);
               e.setCorreo(correo);
               e.setTelefono(telefono);
               e.setCiudad(ciudad);
               
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
    public String eliminar(@FormParam ("pkPersona")String pkPersona){
        String mensaje="{\"exitoso\":false,\"motivo\":";
        Persona e=BuscarPorId(pkPersona);
        
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
    
    public Persona BuscarPorId(String pkPersona){
        Persona p = null;
        TypedQuery<Persona>qry;
        qry=getEntityManager().createQuery("SELECT p FROM Persona p WHERE p.pkPersona = :pkPersona and p.eliminado = :eliminado", Persona.class);
        qry.setParameter("pkPersona", pkPersona);
        qry.setParameter("eliminado", false);

        try {
            return qry.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
