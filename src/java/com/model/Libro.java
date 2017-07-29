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
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
    , @NamedQuery(name = "Libro.findByPkLibro", query = "SELECT l FROM Libro l WHERE l.pkLibro = :pkLibro")
    , @NamedQuery(name = "Libro.findByCodigoLibro", query = "SELECT l FROM Libro l WHERE l.codigoLibro = :codigoLibro")
    , @NamedQuery(name = "Libro.findByNombre", query = "SELECT l FROM Libro l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Libro.findByAutor", query = "SELECT l FROM Libro l WHERE l.autor = :autor")
    , @NamedQuery(name = "Libro.findByEdicion", query = "SELECT l FROM Libro l WHERE l.edicion = :edicion")
    , @NamedQuery(name = "Libro.findByCiudad", query = "SELECT l FROM Libro l WHERE l.ciudad = :ciudad")
    , @NamedQuery(name = "Libro.findByEstado", query = "SELECT l FROM Libro l WHERE l.estado = :estado")
    , @NamedQuery(name = "Libro.findByA\u00f1o", query = "SELECT l FROM Libro l WHERE l.a\u00f1o = :a\u00f1o")
    , @NamedQuery(name = "Libro.findByEliminado", query = "SELECT l FROM Libro l WHERE l.eliminado = :eliminado")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pk_libro")
    private String pkLibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo_libro")
    private String codigoLibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "edicion")
    private String edicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "a\u00f1o")
    private int año;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminado")
    private boolean eliminado;
    @JoinColumn(name = "CATEGORIA_pk_categoria", referencedColumnName = "pk_categoria")
    @ManyToOne(optional = false)
    private Categoria cATEGORIApkcategoria;
    @JoinColumn(name = "PROVEEDOR_pk_proveedor", referencedColumnName = "pk_proveedor")
    @ManyToOne(optional = false)
    private Proveedor pROVEEDORpkproveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lIBROpklibro")
    private List<Configuracion> configuracionList;

    public Libro() {
    }

    public Libro(String pkLibro) {
        this.pkLibro = pkLibro;
    }

    public Libro(String pkLibro, String codigoLibro, String nombre, String autor, String edicion, String ciudad, boolean estado, int año, boolean eliminado, Categoria cATEGORIApkcategoria, Proveedor pROVEEDORpkproveedor) {
        this.pkLibro = pkLibro;
        this.codigoLibro = codigoLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.edicion = edicion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.año = año;
        this.eliminado = eliminado;
        this.cATEGORIApkcategoria = cATEGORIApkcategoria;
        this.pROVEEDORpkproveedor = pROVEEDORpkproveedor;
    }

    public String getPkLibro() {
        return pkLibro;
    }

    public void setPkLibro(String pkLibro) {
        this.pkLibro = pkLibro;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Categoria getCATEGORIApkcategoria() {
        return cATEGORIApkcategoria;
    }

    public void setCATEGORIApkcategoria(Categoria cATEGORIApkcategoria) {
        this.cATEGORIApkcategoria = cATEGORIApkcategoria;
    }

    public Proveedor getPROVEEDORpkproveedor() {
        return pROVEEDORpkproveedor;
    }

    public void setPROVEEDORpkproveedor(Proveedor pROVEEDORpkproveedor) {
        this.pROVEEDORpkproveedor = pROVEEDORpkproveedor;
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
        hash += (pkLibro != null ? pkLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.pkLibro == null && other.pkLibro != null) || (this.pkLibro != null && !this.pkLibro.equals(other.pkLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Libro[ pkLibro=" + pkLibro + " ]";
    }
    
}
