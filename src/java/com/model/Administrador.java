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
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByPkAdministrador", query = "SELECT a FROM Administrador a WHERE a.pkAdministrador = :pkAdministrador")
    , @NamedQuery(name = "Administrador.findByTipoUsuario", query = "SELECT a FROM Administrador a WHERE a.tipoUsuario = :tipoUsuario")
    , @NamedQuery(name = "Administrador.findByClave", query = "SELECT a FROM Administrador a WHERE a.clave = :clave")
    , @NamedQuery(name = "Administrador.findByEliminado", query = "SELECT a FROM Administrador a WHERE a.eliminado = :eliminado")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "pk_administrador")
    private String pkAdministrador;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aDMINISTRADORpkadministrador")
    private List<Reporte> reporteList;

    public Administrador() {
    }

    public Administrador(String pkAdministrador) {
        this.pkAdministrador = pkAdministrador;
    }

    public Administrador(String pkAdministrador, String tipoUsuario, String clave, boolean eliminado) {
        this.pkAdministrador = pkAdministrador;
        this.tipoUsuario = tipoUsuario;
        this.clave = clave;
        this.eliminado = eliminado;
    }

    public String getPkAdministrador() {
        return pkAdministrador;
    }

    public void setPkAdministrador(String pkAdministrador) {
        this.pkAdministrador = pkAdministrador;
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
    public List<Reporte> getReporteList() {
        return reporteList;
    }

    public void setReporteList(List<Reporte> reporteList) {
        this.reporteList = reporteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkAdministrador != null ? pkAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.pkAdministrador == null && other.pkAdministrador != null) || (this.pkAdministrador != null && !this.pkAdministrador.equals(other.pkAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Administrador[ pkAdministrador=" + pkAdministrador + " ]";
    }
    
}
