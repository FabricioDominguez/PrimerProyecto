/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL_USER
 */
@Entity
@Table(name = "equipogps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipogps.findAll", query = "SELECT e FROM Equipogps e"),
    @NamedQuery(name = "Equipogps.findByIdGps", query = "SELECT e FROM Equipogps e WHERE e.idGps = :idGps"),
    @NamedQuery(name = "Equipogps.findByEquipo", query = "SELECT e FROM Equipogps e WHERE e.equipo = :equipo"),
    @NamedQuery(name = "Equipogps.findByImei", query = "SELECT e FROM Equipogps e WHERE e.imei = :imei"),
    @NamedQuery(name = "Equipogps.findByNumeroChip", query = "SELECT e FROM Equipogps e WHERE e.numeroChip = :numeroChip"),
    @NamedQuery(name = "Equipogps.findBySerie", query = "SELECT e FROM Equipogps e WHERE e.serie = :serie"),
    @NamedQuery(name = "Equipogps.findByCosto", query = "SELECT e FROM Equipogps e WHERE e.costo = :costo"),
    @NamedQuery(name = "Equipogps.findByObservacion", query = "SELECT e FROM Equipogps e WHERE e.observacion = :observacion")})
public class Equipogps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gps")
    private Long idGps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "equipo")
    private String equipo;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "imei")
    private String imei;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_chip")
    private int numeroChip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private double costo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "observacion")
    private String observacion;

    public Equipogps() {
    }

    public Equipogps(Long idGps) {
        this.idGps = idGps;
    }

    public Equipogps(Long idGps, String equipo, String imei, int numeroChip, String serie, double costo, String observacion) {
        this.idGps = idGps;
        this.equipo = equipo;
        this.imei = imei;
        this.numeroChip = numeroChip;
        this.serie = serie;
        this.costo = costo;
        this.observacion = observacion;
    }

    public Long getIdGps() {
        return idGps;
    }

    public void setIdGps(Long idGps) {
        this.idGps = idGps;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getNumeroChip() {
        return numeroChip;
    }

    public void setNumeroChip(int numeroChip) {
        this.numeroChip = numeroChip;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGps != null ? idGps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipogps)) {
            return false;
        }
        Equipogps other = (Equipogps) object;
        if ((this.idGps == null && other.idGps != null) || (this.idGps != null && !this.idGps.equals(other.idGps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Equipogps{" + "idGps=" + idGps + ", equipo=" + equipo + ", imei=" + imei + ", numeroChip=" + numeroChip + ", serie=" + serie + ", costo=" + costo + ", observacion=" + observacion + '}';
    }

 
    
}
