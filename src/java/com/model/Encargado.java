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
@Table(name = "encargado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encargado.findAll", query = "SELECT e FROM Encargado e")
    , @NamedQuery(name = "Encargado.findByPkEncargado", query = "SELECT e FROM Encargado e WHERE e.pkEncargado = :pkEncargado")
    , @NamedQuery(name = "Encargado.findByTipoUsuario", query = "SELECT e FROM Encargado e WHERE e.tipoUsuario = :tipoUsuario")
    , @NamedQuery(name = "Encargado.findByClave", query = "SELECT e FROM Encargado e WHERE e.clave = :clave")
    , @NamedQuery(name = "Encargado.findByEliminado", query = "SELECT e FROM Encargado e WHERE e.eliminado = :eliminado")})
public class Encargado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "pk_encargado")
    private String pkEncargado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminado")
    private boolean eliminado;
    @JoinColumn(name = "PERSONA_pk_persona", referencedColumnName = "pk_persona")
    @ManyToOne(optional = false)
    private Persona pERSONApkpersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNCARGADOpkencargado")
    private List<Configuracion> configuracionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNCARGADOpkencargado")
    private List<Reporte> reporteList;

    public Encargado() {
    }

    public Encargado(String pkEncargado) {
        this.pkEncargado = pkEncargado;
    }

    public Encargado(String pkEncargado, String tipoUsuario, String clave, boolean eliminado) {
        this.pkEncargado = pkEncargado;
        this.tipoUsuario = tipoUsuario;
        this.clave = clave;
        this.eliminado = eliminado;
    }

    public String getPkEncargado() {
        return pkEncargado;
    }

    public void setPkEncargado(String pkEncargado) {
        this.pkEncargado = pkEncargado;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Persona getPERSONApkpersona() {
        return pERSONApkpersona;
    }

    public void setPERSONApkpersona(Persona pERSONApkpersona) {
        this.pERSONApkpersona = pERSONApkpersona;
    }

    @XmlTransient
    public List<Configuracion> getConfiguracionList() {
        return configuracionList;
    }

    public void setConfiguracionList(List<Configuracion> configuracionList) {
        this.configuracionList = configuracionList;
    }

    @XmlTransient
    public List<Reporte> getReporteList() {
        return reporteList;
    }

    public void setReporteList(List<Reporte> reporteList) {
        this.reporteList = reporteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEncargado != null ? pkEncargado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encargado)) {
            return false;
        }
        Encargado other = (Encargado) object;
        if ((this.pkEncargado == null && other.pkEncargado != null) || (this.pkEncargado != null && !this.pkEncargado.equals(other.pkEncargado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Encargado[ pkEncargado=" + pkEncargado + " ]";
    }
    
}
