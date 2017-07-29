/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Categoria;
import static com.model.Configuracion_.pROVEEDORpkproveedor;
import com.model.Libro;
import com.model.Persona;
import com.model.Proveedor;
import static com.model.Proveedor_.pkProveedor;
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
@Path("com.model.libro")
public class LibroFacadeREST extends AbstractFacade<Libro> {
    
    @EJB
    ProveedorFacadeREST proveedorFacadeREST;
    
    @EJB
    CategoriaFacadeREST categoriaFacadeREST;
    
    

    @PersistenceContext(unitName = "PROYECTO_FINALPU")
    private EntityManager em;

    public LibroFacadeREST() {
        super(Libro.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Libro entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Libro entity) {
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
    public Libro find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Libro> findAll() {
        return null;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Libro> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public String crear(@FormParam("pkLibro")String pkLibro,@FormParam("codigoLibro")String codigoLibro,@FormParam("nombre")String nombre,@FormParam("autor")String autor,@FormParam("edicion")String edicion,@FormParam("ciudad")String ciudad,@FormParam("estado") boolean estado,@FormParam("año")int año,@FormParam("eliminado") boolean eliminado,@FormParam("pROVEEDORpkproveedor")String pROVEEDORpkproveedor,@FormParam("cATEGORIApkcategoria")String cATEGORIApkcategoria){
        String mensaje="{\"exitoso\":false}";
        Proveedor peri=proveedorFacadeREST.find(pROVEEDORpkproveedor);  
        Categoria cat=categoriaFacadeREST.find(cATEGORIApkcategoria);  

        try{
            create(new Libro(pkLibro,codigoLibro,nombre,autor,edicion,ciudad,estado,año,eliminado,cat,peri));
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
    public List<Libro> consulta(@FormParam("pkLibro") String pkLibro) {
         List<Libro> retorno=obtenersaldo(pkLibro);
         return retorno;
    }
            
    public List<Libro> obtenersaldo(String valor) {
        TypedQuery<Libro> qry;
        qry = getEntityManager().createQuery("SELECT l FROM Libro l WHERE l.pkLibro = :pkLibro ",Libro.class);
        qry.setParameter("pkLibro", valor);
        try {
            return qry.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("pkLibro")String pkLibro,@FormParam("codigoLibro")String codigoLibro,@FormParam("nombre")String nombre,@FormParam("autor")String autor,@FormParam("edicion")String edicion,@FormParam("ciudad")String ciudad,@FormParam("estado") boolean estado,@FormParam("año")int año,@FormParam("eliminado") boolean eliminado,@FormParam("pROVEEDORpkproveedor")String pROVEEDORpkproveedor,@FormParam("cATEGORIApkcategoria")String cATEGORIApkcategoria){
        String mensaje="{\"exitoso\":false,\"motivo\":";
        Libro e= BuscarPorId(pkLibro);
        Proveedor per=proveedorFacadeREST.find(pROVEEDORpkproveedor);  
        Categoria cat=categoriaFacadeREST.find(cATEGORIApkcategoria);
        if (e!=null){
            if (!(pkLibro.equals(""))){
               e.setPkLibro(pkLibro);
               e.setCodigoLibro(codigoLibro);
               e.setNombre(nombre);
               e.setAutor(autor);
               e.setEdicion(edicion);
               e.setCiudad(ciudad);
               e.setEstado(estado);
               e.setAño(año);
               e.setEliminado(eliminado);
               e.setPROVEEDORpkproveedor(per);
               e.setCATEGORIApkcategoria(cat);
               
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
// 
    @POST
    @Path("eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String eliminar(@FormParam ("pkLibro")String pkLibro){
        String mensaje="{\"exitoso\":false,\"motivo\":";
        Libro e=BuscarPorId(pkLibro);
        
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
    
    public Libro BuscarPorId(String pkLibro){
        Libro p = null;
        TypedQuery<Libro>qry;
        qry=getEntityManager().createQuery("SELECT l FROM Libro l WHERE l.pkLibro = :pkLibro and l.eliminado = :eliminado", Libro.class);
        qry.setParameter("pkLibro", pkLibro);
        qry.setParameter("eliminado", false);

        try {
            return qry.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
