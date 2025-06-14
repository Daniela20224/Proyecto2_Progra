/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Alison Espinoza
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "MAHN_VALORACION_SALA")

@SequenceGenerator(name = "valoracion_salas_seq", sequenceName = "SEQ_MAHN_VALORACION_SALAS", allocationSize = 1)
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "MahnValoracionSala.findAll", query = "SELECT m FROM MahnValoracionSala m"),
    @javax.persistence.NamedQuery(name = "MahnValoracionSala.findByIdValoracion", query = "SELECT m FROM MahnValoracionSala m WHERE m.idValoracion = :idValoracion"),
    @javax.persistence.NamedQuery(name = "MahnValoracionSala.findByEstrellas", query = "SELECT m FROM MahnValoracionSala m WHERE m.estrellas = :estrellas"),
    @javax.persistence.NamedQuery(name = "MahnValoracionSala.findByObservacion", query = "SELECT m FROM MahnValoracionSala m WHERE m.observacion = :observacion"),
    @javax.persistence.NamedQuery(name = "MahnValoracionSala.findByFechaValoracion", query = "SELECT m FROM MahnValoracionSala m WHERE m.fechaValoracion = :fechaValoracion")})
public class MahnValoracionSala implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valoracion_salas_seq")
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID_VALORACION")
    private Integer idValoracion;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ESTRELLAS")
    private short estrellas;
    @javax.persistence.Column(name = "OBSERVACION")
    private String observacion;
    @javax.persistence.Column(name = "FECHA_VALORACION")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaValoracion;
    @javax.persistence.JoinColumn(name = "ID_SALA", referencedColumnName = "ID_SALA")
    @javax.persistence.ManyToOne(optional = false)
    private MahnSala idSala;

    public MahnValoracionSala() {
    }

    public MahnValoracionSala(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public MahnValoracionSala(Integer idValoracion, short estrellas) {
        this.idValoracion = idValoracion;
        this.estrellas = estrellas;
    }

    public Integer getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public short getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(short estrellas) {
        this.estrellas = estrellas;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(Date fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
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
        hash += (idValoracion != null ? idValoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnValoracionSala)) {
            return false;
        }
        MahnValoracionSala other = (MahnValoracionSala) object;
        if ((this.idValoracion == null && other.idValoracion != null) || (this.idValoracion != null && !this.idValoracion.equals(other.idValoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MahnValoracionSala[ idValoracion=" + idValoracion + " ]";
    }
    
}
