/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "configuracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracion.findAll", query = "SELECT c FROM Configuracion c")
    , @NamedQuery(name = "Configuracion.findByPkConfiguracion", query = "SELECT c FROM Configuracion c WHERE c.pkConfiguracion = :pkConfiguracion")
    , @NamedQuery(name = "Configuracion.findByInicioAdministrador", query = "SELECT c FROM Configuracion c WHERE c.inicioAdministrador = :inicioAdministrador")
    , @NamedQuery(name = "Configuracion.findByInicioUsuario", query = "SELECT c FROM Configuracion c WHERE c.inicioUsuario = :inicioUsuario")
    , @NamedQuery(name = "Configuracion.findByInicioEncargado", query = "SELECT c FROM Configuracion c WHERE c.inicioEncargado = :inicioEncargado")
    , @NamedQuery(name = "Configuracion.findByAlertas", query = "SELECT c FROM Configuracion c WHERE c.alertas = :alertas")
    , @NamedQuery(name = "Configuracion.findByFechaPrestamo", query = "SELECT c FROM Configuracion c WHERE c.fechaPrestamo = :fechaPrestamo")
    , @NamedQuery(name = "Configuracion.findByFechaDevolucion", query = "SELECT c FROM Configuracion c WHERE c.fechaDevolucion = :fechaDevolucion")
    , @NamedQuery(name = "Configuracion.findByHoraPrestamo", query = "SELECT c FROM Configuracion c WHERE c.horaPrestamo = :horaPrestamo")
    , @NamedQuery(name = "Configuracion.findByHoraDevolucion", query = "SELECT c FROM Configuracion c WHERE c.horaDevolucion = :horaDevolucion")})
public class Configuracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_configuracion")
    private Integer pkConfiguracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "inicio_administrador")
    private String inicioAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "inicio_usuario")
    private String inicioUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "inicio_encargado")
    private String inicioEncargado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "alertas")
    private String alertas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_prestamo")
    @Temporal(TemporalType.TIME)
    private Date horaPrestamo;
    @Column(name = "hora_devolucion")
    @Temporal(TemporalType.TIME)
    private Date horaDevolucion;
    @JoinColumn(name = "CATEGORIA_pk_categoria", referencedColumnName = "pk_categoria")
    @ManyToOne(optional = false)
    private Categoria cATEGORIApkcategoria;
    @JoinColumn(name = "ENCARGADO_pk_encargado", referencedColumnName = "pk_encargado")
    @ManyToOne(optional = false)
    private Encargado eNCARGADOpkencargado;
    @JoinColumn(name = "LIBRO_pk_libro", referencedColumnName = "pk_libro")
    @ManyToOne(optional = false)
    private Libro lIBROpklibro;
    @JoinColumn(name = "PRESTAMO_pk_prestamo", referencedColumnName = "pk_prestamo")
    @ManyToOne(optional = false)
    private Prestamo pRESTAMOpkprestamo;
    @JoinColumn(name = "PROVEEDOR_pk_proveedor", referencedColumnName = "pk_proveedor")
    @ManyToOne(optional = false)
    private Proveedor pROVEEDORpkproveedor;
    @JoinColumn(name = "REPORTE_pk_reporte", referencedColumnName = "pk_reporte")
    @ManyToOne(optional = false)
    private Reporte rEPORTEpkreporte;

    public Configuracion() {
    }

    public Configuracion(Integer pkConfiguracion) {
        this.pkConfiguracion = pkConfiguracion;
    }

    public Configuracion(Integer pkConfiguracion, String inicioAdministrador, String inicioUsuario, String inicioEncargado, String alertas, Date fechaPrestamo, Date fechaDevolucion, Date horaPrestamo) {
        this.pkConfiguracion = pkConfiguracion;
        this.inicioAdministrador = inicioAdministrador;
        this.inicioUsuario = inicioUsuario;
        this.inicioEncargado = inicioEncargado;
        this.alertas = alertas;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.horaPrestamo = horaPrestamo;
    }

    public Integer getPkConfiguracion() {
        return pkConfiguracion;
    }

    public void setPkConfiguracion(Integer pkConfiguracion) {
        this.pkConfiguracion = pkConfiguracion;
    }

    public String getInicioAdministrador() {
        return inicioAdministrador;
    }

    public void setInicioAdministrador(String inicioAdministrador) {
        this.inicioAdministrador = inicioAdministrador;
    }

    public String getInicioUsuario() {
        return inicioUsuario;
    }

    public void setInicioUsuario(String inicioUsuario) {
        this.inicioUsuario = inicioUsuario;
    }

    public String getInicioEncargado() {
        return inicioEncargado;
    }

    public void setInicioEncargado(String inicioEncargado) {
        this.inicioEncargado = inicioEncargado;
    }

    public String getAlertas() {
        return alertas;
    }

    public void setAlertas(String alertas) {
        this.alertas = alertas;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Date getHoraPrestamo() {
        return horaPrestamo;
    }

    public void setHoraPrestamo(Date horaPrestamo) {
        this.horaPrestamo = horaPrestamo;
    }

    public Date getHoraDevolucion() {
        return horaDevolucion;
    }

    public void setHoraDevolucion(Date horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }

    public Categoria getCATEGORIApkcategoria() {
        return cATEGORIApkcategoria;
    }

    public void setCATEGORIApkcategoria(Categoria cATEGORIApkcategoria) {
        this.cATEGORIApkcategoria = cATEGORIApkcategoria;
    }

    public Encargado getENCARGADOpkencargado() {
        return eNCARGADOpkencargado;
    }

    public void setENCARGADOpkencargado(Encargado eNCARGADOpkencargado) {
        this.eNCARGADOpkencargado = eNCARGADOpkencargado;
    }

    public Libro getLIBROpklibro() {
        return lIBROpklibro;
    }

    public void setLIBROpklibro(Libro lIBROpklibro) {
        this.lIBROpklibro = lIBROpklibro;
    }

    public Prestamo getPRESTAMOpkprestamo() {
        return pRESTAMOpkprestamo;
    }

    public void setPRESTAMOpkprestamo(Prestamo pRESTAMOpkprestamo) {
        this.pRESTAMOpkprestamo = pRESTAMOpkprestamo;
    }

    public Proveedor getPROVEEDORpkproveedor() {
        return pROVEEDORpkproveedor;
    }

    public void setPROVEEDORpkproveedor(Proveedor pROVEEDORpkproveedor) {
        this.pROVEEDORpkproveedor = pROVEEDORpkproveedor;
    }

    public Reporte getREPORTEpkreporte() {
        return rEPORTEpkreporte;
    }

    public void setREPORTEpkreporte(Reporte rEPORTEpkreporte) {
        this.rEPORTEpkreporte = rEPORTEpkreporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkConfiguracion != null ? pkConfiguracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracion)) {
            return false;
        }
        Configuracion other = (Configuracion) object;
        if ((this.pkConfiguracion == null && other.pkConfiguracion != null) || (this.pkConfiguracion != null && !this.pkConfiguracion.equals(other.pkConfiguracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Configuracion[ pkConfiguracion=" + pkConfiguracion + " ]";
    }
    
}
