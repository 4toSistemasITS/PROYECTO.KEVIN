/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Kevin
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.service.AdministradorFacadeREST.class);
        resources.add(com.service.CategoriaFacadeREST.class);
        resources.add(com.service.ConfiguracionFacadeREST.class);
        resources.add(com.service.EncargadoFacadeREST.class);
        resources.add(com.service.LibroFacadeREST.class);
        resources.add(com.service.NewCrossOriginResourceSharingFilter.class);
        resources.add(com.service.PersonaFacadeREST.class);
        resources.add(com.service.PrestamoFacadeREST.class);
        resources.add(com.service.ProveedorFacadeREST.class);
        resources.add(com.service.ReporteFacadeREST.class);
        resources.add(com.service.UsuarioFacadeREST.class);
    }
    
}
