/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Alison Espinoza
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "MAHN_TEMATICA")

@SequenceGenerator(name = "tematicas_seq", sequenceName = "SEQ_MAHN_TEMATICAS", allocationSize = 1)
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "MahnTematica.findAll", query = "SELECT m FROM MahnTematica m"),
    @javax.persistence.NamedQuery(name = "MahnTematica.findByIdTematica", query = "SELECT m FROM MahnTematica m WHERE m.idTematica = :idTematica"),
    @javax.persistence.NamedQuery(name = "MahnTematica.findByNombre", query = "SELECT m FROM MahnTematica m WHERE m.nombre = :nombre"),
    @javax.persistence.NamedQuery(name = "MahnTematica.findByCaracteristicas", query = "SELECT m FROM MahnTematica m WHERE m.caracteristicas = :caracteristicas"),
    @javax.persistence.NamedQuery(name = "MahnTematica.findByEpoca", query = "SELECT m FROM MahnTematica m WHERE m.epoca = :epoca")})
public class MahnTematica implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tematicas_seq")
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID_TEMATICA")
    private Integer idTematica;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "NOMBRE")
    private String nombre;
    @javax.persistence.Column(name = "CARACTERISTICAS")
    private String caracteristicas;
    @javax.persistence.Column(name = "EPOCA")
    private String epoca;
    @javax.persistence.JoinColumn(name = "ID_SALA", referencedColumnName = "ID_SALA")
    @javax.persistence.ManyToOne(optional = false)
    private MahnSala idSala;

    public MahnTematica() {
    }

    public MahnTematica(Integer idTematica) {
        this.idTematica = idTematica;
    }

    public MahnTematica(Integer idTematica, String nombre) {
        this.idTematica = idTematica;
        this.nombre = nombre;
    }

    public Integer getIdTematica() {
        return idTematica;
    }

    public void setIdTematica(Integer idTematica) {
        this.idTematica = idTematica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public MahnSala getIdSala() {
        return idSala;
    }

    public void setIdSala(MahnSala idSala) {
        this.idSala = idSala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTematica != null ? idTematica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnTematica)) {
            return false;
        }
        MahnTematica other = (MahnTematica) object;
        if ((this.idTematica == null && other.idTematica != null) || (this.idTematica != null && !this.idTematica.equals(other.idTematica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MahnTematica[ idTematica=" + idTematica + " ]";
    }
    
}
