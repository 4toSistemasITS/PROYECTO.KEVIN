/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import static com.model.Persona_.pkPersona;
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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByPkProveedor", query = "SELECT p FROM Proveedor p WHERE p.pkProveedor = :pkProveedor")
    , @NamedQuery(name = "Proveedor.findByNombreProveedor", query = "SELECT p FROM Proveedor p WHERE p.nombreProveedor = :nombreProveedor")
    , @NamedQuery(name = "Proveedor.findByEliminado", query = "SELECT p FROM Proveedor p WHERE p.eliminado = :eliminado")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "pk_proveedor")
    private String pkProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_proveedor")
    private String nombreProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminado")
    private boolean eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROVEEDORpkproveedor")
    private List<Libro> libroList;
    @JoinColumn(name = "PERSONA_pk_persona", referencedColumnName = "pk_persona")
    @ManyToOne(optional = false)
    private Persona pERSONApkpersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROVEEDORpkproveedor")
    private List<Configuracion> configuracionList;

    public Proveedor() {
    }

    public Proveedor(String pkProveedor) {
        this.pkProveedor = pkProveedor;
    }

    public Proveedor(String pkProveedor, String nombreProveedor, boolean eliminado, Persona pERSONApkpersona) {
        this.pkProveedor = pkProveedor;
        this.nombreProveedor = nombreProveedor;
        this.eliminado = eliminado;
        this.pERSONApkpersona = pERSONApkpersona;
    }

    public String getPkProveedor() {
        return pkProveedor;
    }

    public void setPkProveedor(String pkProveedor) {
        this.pkProveedor = pkProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @XmlTransient
    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProveedor != null ? pkProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.pkProveedor == null && other.pkProveedor != null) || (this.pkProveedor != null && !this.pkProveedor.equals(other.pkProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Proveedor[ pkProveedor=" + pkProveedor + " ]";
    }
    
}
