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
@javax.persistence.Table(name = "MAHN_SALA")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "MahnSala.findAll", query = "SELECT m FROM MahnSala m"),
    @javax.persistence.NamedQuery(name = "MahnSala.findByIdSala", query = "SELECT m FROM MahnSala m WHERE m.idSala = :idSala"),
    @javax.persistence.NamedQuery(name = "MahnSala.findByNombre", query = "SELECT m FROM MahnSala m WHERE m.nombre = :nombre"),
    @javax.persistence.NamedQuery(name = "MahnSala.findByDescripcion", query = "SELECT m FROM MahnSala m WHERE m.descripcion = :descripcion")})
public class MahnSala implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID_SALA")
    private Integer idSala;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "NOMBRE")
    private String nombre;
    @javax.persistence.Column(name = "DESCRIPCION")
    private String descripcion;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "idSala")
    private Collection<MahnTematica> mahnTematicaCollection;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "idSala")
    private Collection<MahnColeccion> mahnColeccionCollection;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "idSala")
    private Collection<MahnPrecios> mahnPreciosCollection;
    @javax.persistence.JoinColumn(name = "ID_MUSEO", referencedColumnName = "ID_MUSEO")
    @javax.persistence.ManyToOne(optional = false)
    private MahnMuseo idMuseo;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "idSala")
    private Collection<MahnValoracionSala> mahnValoracionSalaCollection;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "idSala")
    private Collection<MahnEntradaSala> mahnEntradaSalaCollection;

    public MahnSala() {
    }

    public MahnSala(Integer idSala) {
        this.idSala = idSala;
    }

    public MahnSala(Integer idSala, String nombre) {
        this.idSala = idSala;
        this.nombre = nombre;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<MahnTematica> getMahnTematicaCollection() {
        return mahnTematicaCollection;
    }

    public void setMahnTematicaCollection(Collection<MahnTematica> mahnTematicaCollection) {
        this.mahnTematicaCollection = mahnTematicaCollection;
    }

    public Collection<MahnColeccion> getMahnColeccionCollection() {
        return mahnColeccionCollection;
    }

    public void setMahnColeccionCollection(Collection<MahnColeccion> mahnColeccionCollection) {
        this.mahnColeccionCollection = mahnColeccionCollection;
    }

    public Collection<MahnPrecios> getMahnPreciosCollection() {
        return mahnPreciosCollection;
    }

    public void setMahnPreciosCollection(Collection<MahnPrecios> mahnPreciosCollection) {
        this.mahnPreciosCollection = mahnPreciosCollection;
    }

    public MahnMuseo getIdMuseo() {
        return idMuseo;
    }

    public void setIdMuseo(MahnMuseo idMuseo) {
        this.idMuseo = idMuseo;
    }

    public Collection<MahnValoracionSala> getMahnValoracionSalaCollection() {
        return mahnValoracionSalaCollection;
    }

    public void setMahnValoracionSalaCollection(Collection<MahnValoracionSala> mahnValoracionSalaCollection) {
        this.mahnValoracionSalaCollection = mahnValoracionSalaCollection;
    }

    public Collection<MahnEntradaSala> getMahnEntradaSalaCollection() {
        return mahnEntradaSalaCollection;
    }

    public void setMahnEntradaSalaCollection(Collection<MahnEntradaSala> mahnEntradaSalaCollection) {
        this.mahnEntradaSalaCollection = mahnEntradaSalaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSala != null ? idSala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnSala)) {
            return false;
        }
        MahnSala other = (MahnSala) object;
        if ((this.idSala == null && other.idSala != null) || (this.idSala != null && !this.idSala.equals(other.idSala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MahnSala[ idSala=" + idSala + " ]";
    }
    
}
