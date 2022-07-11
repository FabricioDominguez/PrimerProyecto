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
@Table(name = "casas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casas.findAll", query = "SELECT c FROM Casas c"),
    @NamedQuery(name = "Casas.findByIdCasa", query = "SELECT c FROM Casas c WHERE c.idCasa = :idCasa"),
    @NamedQuery(name = "Casas.findByCodigo", query = "SELECT c FROM Casas c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Casas.findByPropietario", query = "SELECT c FROM Casas c WHERE c.propietario = :propietario"),
    @NamedQuery(name = "Casas.findByArea", query = "SELECT c FROM Casas c WHERE c.area = :area"),
    @NamedQuery(name = "Casas.findByCostoTotal", query = "SELECT c FROM Casas c WHERE c.costoTotal = :costoTotal"),
    @NamedQuery(name = "Casas.findByTipoTerreno", query = "SELECT c FROM Casas c WHERE c.tipoTerreno = :tipoTerreno"),
    @NamedQuery(name = "Casas.findByCostoKm", query = "SELECT c FROM Casas c WHERE c.costoKm = :costoKm")})
public class Casas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_casa")
    private Long idCasa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "propietario")
    private String propietario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "area")
    private double area;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_total")
    private double costoTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo_terreno")
    private String tipoTerreno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_km")
    private double costoKm;

    public Casas() {
    }

    public Casas(Long idCasa) {
        this.idCasa = idCasa;
    }

    public Casas(double costoTotal) {
        this.costoTotal = costoKm * area ;
    }

    
    
    public Casas(Long idCasa, String codigo, String propietario, double area, double costoTotal, String tipoTerreno, double costoKm) {
        this.idCasa = idCasa;
        this.codigo = codigo;
        this.propietario = propietario;
        this.area = area;
        this.costoTotal = costoTotal;
        this.tipoTerreno = tipoTerreno;
        this.costoKm = costoKm;
    }

    public Long getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(Long idCasa) {
        this.idCasa = idCasa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCostoTotal() {

       
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(String tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public double getCostoKm() {
        return costoKm;
    }

    public void setCostoKm(double costoKm) {
        this.costoKm = costoKm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasa != null ? idCasa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casas)) {
            return false;
        }
        Casas other = (Casas) object;
        if ((this.idCasa == null && other.idCasa != null) || (this.idCasa != null && !this.idCasa.equals(other.idCasa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Casas{" + "idCasa=" + idCasa + ", codigo=" + codigo + ", propietario=" + propietario + ", area=" + area + ", costoTotal=" + costoTotal + ", tipoTerreno=" + tipoTerreno + ", costoKm=" + costoKm + '}';
    }

   

}
