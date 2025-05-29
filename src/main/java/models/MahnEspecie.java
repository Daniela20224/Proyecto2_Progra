/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Alison Espinoza
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "MAHN_ESPECIE")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "MahnEspecie.findAll", query = "SELECT m FROM MahnEspecie m"),
    @javax.persistence.NamedQuery(name = "MahnEspecie.findByIdEspecie", query = "SELECT m FROM MahnEspecie m WHERE m.idEspecie = :idEspecie"),
    @javax.persistence.NamedQuery(name = "MahnEspecie.findByNombreCientifico", query = "SELECT m FROM MahnEspecie m WHERE m.nombreCientifico = :nombreCientifico"),
    @javax.persistence.NamedQuery(name = "MahnEspecie.findByNombreComun", query = "SELECT m FROM MahnEspecie m WHERE m.nombreComun = :nombreComun"),
    @javax.persistence.NamedQuery(name = "MahnEspecie.findByFechaExtincion", query = "SELECT m FROM MahnEspecie m WHERE m.fechaExtincion = :fechaExtincion"),
    @javax.persistence.NamedQuery(name = "MahnEspecie.findByEpoca", query = "SELECT m FROM MahnEspecie m WHERE m.epoca = :epoca"),
    @javax.persistence.NamedQuery(name = "MahnEspecie.findByPeso", query = "SELECT m FROM MahnEspecie m WHERE m.peso = :peso"),
    @javax.persistence.NamedQuery(name = "MahnEspecie.findByTamano", query = "SELECT m FROM MahnEspecie m WHERE m.tamano = :tamano"),
    @javax.persistence.NamedQuery(name = "MahnEspecie.findByCaracteristicas", query = "SELECT m FROM MahnEspecie m WHERE m.caracteristicas = :caracteristicas")})
public class MahnEspecie implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID_ESPECIE")
    private Integer idEspecie;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "NOMBRE_CIENTIFICO")
    private String nombreCientifico;
    @javax.persistence.Column(name = "NOMBRE_COMUN")
    private String nombreComun;
    @javax.persistence.Column(name = "FECHA_EXTINCION")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaExtincion;
    @javax.persistence.Column(name = "EPOCA")
    private String epoca;
    @javax.persistence.Column(name = "PESO")
    private Integer peso;
    @javax.persistence.Column(name = "TAMANO")
    private String tamano;
    @javax.persistence.Column(name = "CARACTERISTICAS")
    private String caracteristicas;
    @javax.persistence.JoinColumn(name = "ID_COLECCION", referencedColumnName = "ID_COLECCION")
    @javax.persistence.ManyToOne(optional = false)
    private MahnColeccion idColeccion;

    public MahnEspecie() {
    }

    public MahnEspecie(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    public MahnEspecie(Integer idEspecie, String nombreCientifico) {
        this.idEspecie = idEspecie;
        this.nombreCientifico = nombreCientifico;
    }

    public Integer getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public Date getFechaExtincion() {
        return fechaExtincion;
    }

    public void setFechaExtincion(Date fechaExtincion) {
        this.fechaExtincion = fechaExtincion;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public MahnColeccion getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(MahnColeccion idColeccion) {
        this.idColeccion = idColeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecie != null ? idEspecie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnEspecie)) {
            return false;
        }
        MahnEspecie other = (MahnEspecie) object;
        if ((this.idEspecie == null && other.idEspecie != null) || (this.idEspecie != null && !this.idEspecie.equals(other.idEspecie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MahnEspecie[ idEspecie=" + idEspecie + " ]";
    }
    
}
