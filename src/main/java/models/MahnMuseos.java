/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alison Espinoza
 */
@Entity
@Table(name = "MAHN_MUSEOS")
@NamedQueries({
    @NamedQuery(name = "MahnMuseos.findAll", query = "SELECT m FROM MahnMuseos m"),
    @NamedQuery(name = "MahnMuseos.findByIdMuseo", query = "SELECT m FROM MahnMuseos m WHERE m.idMuseo = :idMuseo"),
    @NamedQuery(name = "MahnMuseos.findByNombre", query = "SELECT m FROM MahnMuseos m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "MahnMuseos.findByTipoMuseo", query = "SELECT m FROM MahnMuseos m WHERE m.tipoMuseo = :tipoMuseo"),
    @NamedQuery(name = "MahnMuseos.findByUbicacion", query = "SELECT m FROM MahnMuseos m WHERE m.ubicacion = :ubicacion"),
    @NamedQuery(name = "MahnMuseos.findByFechaFundacion", query = "SELECT m FROM MahnMuseos m WHERE m.fechaFundacion = :fechaFundacion"),
    @NamedQuery(name = "MahnMuseos.findByNombreDirector", query = "SELECT m FROM MahnMuseos m WHERE m.nombreDirector = :nombreDirector"),
    @NamedQuery(name = "MahnMuseos.findBySitioWeb", query = "SELECT m FROM MahnMuseos m WHERE m.sitioWeb = :sitioWeb")})
public class MahnMuseos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MUSEO")
    private BigDecimal idMuseo;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "TIPO_MUSEO")
    private String tipoMuseo;
    @Basic(optional = false)
    @Column(name = "UBICACION")
    private String ubicacion;
    @Column(name = "FECHA_FUNDACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFundacion;
    @Column(name = "NOMBRE_DIRECTOR")
    private String nombreDirector;
    @Column(name = "SITIO_WEB")
    private String sitioWeb;

    public MahnMuseos() {
    }

    public MahnMuseos(BigDecimal idMuseo) {
        this.idMuseo = idMuseo;
    }

    public MahnMuseos(BigDecimal idMuseo, String nombre, String tipoMuseo, String ubicacion) {
        this.idMuseo = idMuseo;
        this.nombre = nombre;
        this.tipoMuseo = tipoMuseo;
        this.ubicacion = ubicacion;
    }

    public BigDecimal getIdMuseo() {
        return idMuseo;
    }

    public void setIdMuseo(BigDecimal idMuseo) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMuseo != null ? idMuseo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnMuseos)) {
            return false;
        }
        MahnMuseos other = (MahnMuseos) object;
        if ((this.idMuseo == null && other.idMuseo != null) || (this.idMuseo != null && !this.idMuseo.equals(other.idMuseo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Museo{" + idMuseo +  "}: "+ nombre ;
    }
    
}
