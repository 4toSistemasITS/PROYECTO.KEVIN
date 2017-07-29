/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r")
    , @NamedQuery(name = "Reporte.findByPkReporte", query = "SELECT r FROM Reporte r WHERE r.pkReporte = :pkReporte")
    , @NamedQuery(name = "Reporte.findByTipoReporte", query = "SELECT r FROM Reporte r WHERE r.tipoReporte = :tipoReporte")
    , @NamedQuery(name = "Reporte.findByEliminado", query = "SELECT r FROM Reporte r WHERE r.eliminado = :eliminado")})
public class Reporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_reporte")
    private Integer pkReporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_reporte")
    private String tipoReporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminado")
    private boolean eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rEPORTEpkreporte")
    private List<Configuracion> configuracionList;
    @JoinColumn(name = "ADMINISTRADOR_pk_administrador", referencedColumnName = "pk_administrador")
    @ManyToOne(optional = false)
    private Administrador aDMINISTRADORpkadministrador;
    @JoinColumn(name = "ENCARGADO_pk_encargado", referencedColumnName = "pk_encargado")
    @ManyToOne(optional = false)
    private Encargado eNCARGADOpkencargado;
    @JoinColumn(name = "PRESTAMO_pk_prestamo", referencedColumnName = "pk_prestamo")
    @ManyToOne(optional = false)
    private Prestamo pRESTAMOpkprestamo;
    @JoinColumn(name = "USUARIO_pk_usuario", referencedColumnName = "pk_usuario")
    @ManyToOne(optional = false)
    private Usuario uSUARIOpkusuario;

    public Reporte() {
    }

    public Reporte(Integer pkReporte) {
        this.pkReporte = pkReporte;
    }

    public Reporte(Integer pkReporte, String tipoReporte, boolean eliminado) {
        this.pkReporte = pkReporte;
        this.tipoReporte = tipoReporte;
        this.eliminado = eliminado;
    }

    public Integer getPkReporte() {
        return pkReporte;
    }

    public void setPkReporte(Integer pkReporte) {
        this.pkReporte = pkReporte;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @XmlTransient
    public List<Configuracion> getConfiguracionList() {
        return configuracionList;
    }

    public void setConfiguracionList(List<Configuracion> configuracionList) {
        this.configuracionList = configuracionList;
    }

    public Administrador getADMINISTRADORpkadministrador() {
        return aDMINISTRADORpkadministrador;
    }

    public void setADMINISTRADORpkadministrador(Administrador aDMINISTRADORpkadministrador) {
        this.aDMINISTRADORpkadministrador = aDMINISTRADORpkadministrador;
    }

    public Encargado getENCARGADOpkencargado() {
        return eNCARGADOpkencargado;
    }

    public void setENCARGADOpkencargado(Encargado eNCARGADOpkencargado) {
        this.eNCARGADOpkencargado = eNCARGADOpkencargado;
    }

    public Prestamo getPRESTAMOpkprestamo() {
        return pRESTAMOpkprestamo;
    }

    public void setPRESTAMOpkprestamo(Prestamo pRESTAMOpkprestamo) {
        this.pRESTAMOpkprestamo = pRESTAMOpkprestamo;
    }

    public Usuario getUSUARIOpkusuario() {
        return uSUARIOpkusuario;
    }

    public void setUSUARIOpkusuario(Usuario uSUARIOpkusuario) {
        this.uSUARIOpkusuario = uSUARIOpkusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkReporte != null ? pkReporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.pkReporte == null && other.pkReporte != null) || (this.pkReporte != null && !this.pkReporte.equals(other.pkReporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Reporte[ pkReporte=" + pkReporte + " ]";
    }
    
}
