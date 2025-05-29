/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Alison Espinoza
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "MAHN_COLECCION")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "MahnColeccion.findAll", query = "SELECT m FROM MahnColeccion m"),
    @javax.persistence.NamedQuery(name = "MahnColeccion.findByIdColeccion", query = "SELECT m FROM MahnColeccion m WHERE m.idColeccion = :idColeccion"),
    @javax.persistence.NamedQuery(name = "MahnColeccion.findByNombre", query = "SELECT m FROM MahnColeccion m WHERE m.nombre = :nombre"),
    @javax.persistence.NamedQuery(name = "MahnColeccion.findBySiglo", query = "SELECT m FROM MahnColeccion m WHERE m.siglo = :siglo"),
    @javax.persistence.NamedQuery(name = "MahnColeccion.findByObservacion", query = "SELECT m FROM MahnColeccion m WHERE m.observacion = :observacion")})
public class MahnColeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID_COLECCION")
    private Integer idColeccion;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "NOMBRE")
    private String nombre;
    @javax.persistence.Column(name = "SIGLO")
    private String siglo;
    @javax.persistence.Column(name = "OBSERVACION")
    private String observacion;
    @javax.persistence.JoinColumn(name = "ID_SALA", referencedColumnName = "ID_SALA")
    @javax.persistence.ManyToOne(optional = false)
    private MahnSala idSala;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "idColeccion")
    private Collection<MahnEspecie> mahnEspecieCollection;

    public MahnColeccion() {
    }

    public MahnColeccion(Integer idColeccion) {
        this.idColeccion = idColeccion;
    }

    public MahnColeccion(Integer idColeccion, String nombre) {
        this.idColeccion = idColeccion;
        this.nombre = nombre;
    }

    public Integer getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(Integer idColeccion) {
        this.idColeccion = idColeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglo() {
        return siglo;
    }

    public void setSiglo(String siglo) {
        this.siglo = siglo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public MahnSala getIdSala() {
        return idSala;
    }

    public void setIdSala(MahnSala idSala) {
        this.idSala = idSala;
    }

    public Collection<MahnEspecie> getMahnEspecieCollection() {
        return mahnEspecieCollection;
    }

    public void setMahnEspecieCollection(Collection<MahnEspecie> mahnEspecieCollection) {
        this.mahnEspecieCollection = mahnEspecieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColeccion != null ? idColeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnColeccion)) {
            return false;
        }
        MahnColeccion other = (MahnColeccion) object;
        if ((this.idColeccion == null && other.idColeccion != null) || (this.idColeccion != null && !this.idColeccion.equals(other.idColeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MahnColeccion[ idColeccion=" + idColeccion + " ]";
    }
    
}
