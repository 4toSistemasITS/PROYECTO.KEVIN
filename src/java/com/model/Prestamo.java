/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "prestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p")
    , @NamedQuery(name = "Prestamo.findByPkPrestamo", query = "SELECT p FROM Prestamo p WHERE p.pkPrestamo = :pkPrestamo")
    , @NamedQuery(name = "Prestamo.findByNumeroPrestamo", query = "SELECT p FROM Prestamo p WHERE p.numeroPrestamo = :numeroPrestamo")
    , @NamedQuery(name = "Prestamo.findByFechaPrestamo", query = "SELECT p FROM Prestamo p WHERE p.fechaPrestamo = :fechaPrestamo")
    , @NamedQuery(name = "Prestamo.findByFechaDevolucion", query = "SELECT p FROM Prestamo p WHERE p.fechaDevolucion = :fechaDevolucion")
    , @NamedQuery(name = "Prestamo.findByHoraPrestamo", query = "SELECT p FROM Prestamo p WHERE p.horaPrestamo = :horaPrestamo")
    , @NamedQuery(name = "Prestamo.findByHoraDevolucion", query = "SELECT p FROM Prestamo p WHERE p.horaDevolucion = :horaDevolucion")
    , @NamedQuery(name = "Prestamo.findByMultas", query = "SELECT p FROM Prestamo p WHERE p.multas = :multas")
    , @NamedQuery(name = "Prestamo.findByEliminado", query = "SELECT p FROM Prestamo p WHERE p.eliminado = :eliminado")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_prestamo")
    private Integer pkPrestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_prestamo")
    private int numeroPrestamo;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_devolucion")
    @Temporal(TemporalType.TIME)
    private Date horaDevolucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "multas")
    private String multas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminado")
    private boolean eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pRESTAMOpkprestamo")
    private List<Configuracion> configuracionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pRESTAMOpkprestamo")
    private List<Reporte> reporteList;

    public Prestamo() {
    }

    public Prestamo(Integer pkPrestamo) {
        this.pkPrestamo = pkPrestamo;
    }

    public Prestamo(Integer pkPrestamo, int numeroPrestamo, Date fechaPrestamo, Date fechaDevolucion, Date horaPrestamo, Date horaDevolucion, String multas, boolean eliminado) {
        this.pkPrestamo = pkPrestamo;
        this.numeroPrestamo = numeroPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.horaPrestamo = horaPrestamo;
        this.horaDevolucion = horaDevolucion;
        this.multas = multas;
        this.eliminado = eliminado;
    }

    public Integer getPkPrestamo() {
        return pkPrestamo;
    }

    public void setPkPrestamo(Integer pkPrestamo) {
        this.pkPrestamo = pkPrestamo;
    }

    public int getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(int numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
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

    public String getMultas() {
        return multas;
    }

    public void setMultas(String multas) {
        this.multas = multas;
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
        hash += (pkPrestamo != null ? pkPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.pkPrestamo == null && other.pkPrestamo != null) || (this.pkPrestamo != null && !this.pkPrestamo.equals(other.pkPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Prestamo[ pkPrestamo=" + pkPrestamo + " ]";
    }
    
}
