/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Alison Espinoza
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "MAHN_MUSEO")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "MahnMuseo.findAll", query = "SELECT m FROM MahnMuseo m"),
    @javax.persistence.NamedQuery(name = "MahnMuseo.findByIdMuseo", query = "SELECT m FROM MahnMuseo m WHERE m.idMuseo = :idMuseo"),
    @javax.persistence.NamedQuery(name = "MahnMuseo.findByNombre", query = "SELECT m FROM MahnMuseo m WHERE m.nombre = :nombre"),
    @javax.persistence.NamedQuery(name = "MahnMuseo.findByTipoMuseo", query = "SELECT m FROM MahnMuseo m WHERE m.tipoMuseo = :tipoMuseo"),
    @javax.persistence.NamedQuery(name = "MahnMuseo.findByUbicacion", query = "SELECT m FROM MahnMuseo m WHERE m.ubicacion = :ubicacion"),
    @javax.persistence.NamedQuery(name = "MahnMuseo.findByFechaFundacion", query = "SELECT m FROM MahnMuseo m WHERE m.fechaFundacion = :fechaFundacion"),
    @javax.persistence.NamedQuery(name = "MahnMuseo.findByNombreDirector", query = "SELECT m FROM MahnMuseo m WHERE m.nombreDirector = :nombreDirector"),
    @javax.persistence.NamedQuery(name = "MahnMuseo.findBySitioWeb", query = "SELECT m FROM MahnMuseo m WHERE m.sitioWeb = :sitioWeb")})
public class MahnMuseo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID_MUSEO")
    private Integer idMuseo;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "NOMBRE")
    private String nombre;
    @javax.persistence.Column(name = "TIPO_MUSEO")
    private String tipoMuseo;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "UBICACION")
    private String ubicacion;
    @javax.persistence.Column(name = "FECHA_FUNDACION")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaFundacion;
    @javax.persistence.Column(name = "NOMBRE_DIRECTOR")
    private String nombreDirector;
    @javax.persistence.Column(name = "SITIO_WEB")
    private String sitioWeb;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "idMuseo")
    private Collection<MahnSala> mahnSalaCollection;

    public MahnMuseo() {
    }

    public MahnMuseo(Integer idMuseo) {
        this.idMuseo = idMuseo;
    }

    public MahnMuseo(Integer idMuseo, String nombre, String ubicacion) {
        this.idMuseo = idMuseo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public Integer getIdMuseo() {
        return idMuseo;
    }

    public void setIdMuseo(Integer idMuseo) {
        this.idMuseo = idMuseo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoMuseo() {
        return tipoMuseo;
    }

    public void setTipoMuseo(String tipoMuseo) {
        this.tipoMuseo = tipoMuseo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Date fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public Collection<MahnSala> getMahnSalaCollection() {
        return mahnSalaCollection;
    }

    public void setMahnSalaCollection(Collection<MahnSala> mahnSalaCollection) {
        this.mahnSalaCollection = mahnSalaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMuseo != null ? idMuseo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnMuseo)) {
            return false;
        }
        MahnMuseo other = (MahnMuseo) object;
        if ((this.idMuseo == null && other.idMuseo != null) || (this.idMuseo != null && !this.idMuseo.equals(other.idMuseo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MahnMuseo[ idMuseo=" + idMuseo + " ]";
    }
    
}
