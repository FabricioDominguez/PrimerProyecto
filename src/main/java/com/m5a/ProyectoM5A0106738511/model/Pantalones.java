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
@Table(name = "pantalones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pantalones.findAll", query = "SELECT p FROM Pantalones p"),
    @NamedQuery(name = "Pantalones.findByIdPantalon", query = "SELECT p FROM Pantalones p WHERE p.idPantalon = :idPantalon"),
    @NamedQuery(name = "Pantalones.findByMarca", query = "SELECT p FROM Pantalones p WHERE p.marca = :marca"),
    @NamedQuery(name = "Pantalones.findByModelo", query = "SELECT p FROM Pantalones p WHERE p.modelo = :modelo"),
    @NamedQuery(name = "Pantalones.findByFabricante", query = "SELECT p FROM Pantalones p WHERE p.fabricante = :fabricante"),
    @NamedQuery(name = "Pantalones.findByCodigo", query = "SELECT p FROM Pantalones p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Pantalones.findByCosto", query = "SELECT p FROM Pantalones p WHERE p.costo = :costo"),
    @NamedQuery(name = "Pantalones.findByCostoTotal", query = "SELECT p FROM Pantalones p WHERE p.costoTotal = :costoTotal"),
    @NamedQuery(name = "Pantalones.findByOrigen", query = "SELECT p FROM Pantalones p WHERE p.origen = :origen"),
    @NamedQuery(name = "Pantalones.findByCantidad", query = "SELECT p FROM Pantalones p WHERE p.cantidad = :cantidad")})
public class Pantalones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pantalon")
    private Long idPantalon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fabricante")
    private String fabricante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private double costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_total")
    private double costoTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "origen")
    private String origen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;

    public Pantalones() {
    }

    public Pantalones(Long idPantalon) {
        this.idPantalon = idPantalon;
    }

    public Pantalones(Long idPantalon, String marca, String modelo, String fabricante, String codigo, double costo, double costoTotal, String origen, double cantidad) {
        this.idPantalon = idPantalon;
        this.marca = marca;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.codigo = codigo;
        this.costo = costo;
        this.costoTotal = costoTotal;
        this.origen = origen;
        this.cantidad = cantidad;
    }

    public Long getIdPantalon() {
        return idPantalon;
    }

    public void setIdPantalon(Long idPantalon) {
        this.idPantalon = idPantalon;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPantalon != null ? idPantalon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pantalones)) {
            return false;
        }
        Pantalones other = (Pantalones) object;
        if ((this.idPantalon == null && other.idPantalon != null) || (this.idPantalon != null && !this.idPantalon.equals(other.idPantalon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pantalones{" + "idPantalon=" + idPantalon + ", marca=" + marca + ", modelo=" + modelo + ", fabricante=" + fabricante + ", codigo=" + codigo + ", costo=" + costo + ", costoTotal=" + costoTotal + ", origen=" + origen + ", cantidad=" + cantidad + '}';
    }

 

 
    
}
