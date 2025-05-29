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
@javax.persistence.Table(name = "MAHN_ENTRADA")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "MahnEntrada.findAll", query = "SELECT m FROM MahnEntrada m"),
    @javax.persistence.NamedQuery(name = "MahnEntrada.findByIdEntrada", query = "SELECT m FROM MahnEntrada m WHERE m.idEntrada = :idEntrada"),
    @javax.persistence.NamedQuery(name = "MahnEntrada.findByFechaVisita", query = "SELECT m FROM MahnEntrada m WHERE m.fechaVisita = :fechaVisita"),
    @javax.persistence.NamedQuery(name = "MahnEntrada.findByPrecioTotal", query = "SELECT m FROM MahnEntrada m WHERE m.precioTotal = :precioTotal"),
    @javax.persistence.NamedQuery(name = "MahnEntrada.findByTipoTarjeta", query = "SELECT m FROM MahnEntrada m WHERE m.tipoTarjeta = :tipoTarjeta"),
    @javax.persistence.NamedQuery(name = "MahnEntrada.findByUltimosDigitosTarjeta", query = "SELECT m FROM MahnEntrada m WHERE m.ultimosDigitosTarjeta = :ultimosDigitosTarjeta"),
    @javax.persistence.NamedQuery(name = "MahnEntrada.findByCodigoQr", query = "SELECT m FROM MahnEntrada m WHERE m.codigoQr = :codigoQr")})
public class MahnEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID_ENTRADA")
    private Integer idEntrada;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "FECHA_VISITA")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVisita;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "PRECIO_TOTAL")
    private Integer precioTotal;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "TIPO_TARJETA")
    private String tipoTarjeta;
    @javax.persistence.Column(name = "ULTIMOS_DIGITOS_TARJETA")
    private String ultimosDigitosTarjeta;
    @javax.persistence.Column(name = "CODIGO_QR")
    private String codigoQr;
    @javax.persistence.JoinColumn(name = "ID_VISITANTE", referencedColumnName = "ID_VISITANTE")
    @javax.persistence.ManyToOne(optional = false)
    private MahnVisitante idVisitante;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "idEntrada")
    private Collection<MahnEntradaSala> mahnEntradaSalaCollection;

    public MahnEntrada() {
    }

    public MahnEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public MahnEntrada(Integer idEntrada, Date fechaVisita, Integer precioTotal, String tipoTarjeta) {
        this.idEntrada = idEntrada;
        this.fechaVisita = fechaVisita;
        this.precioTotal = precioTotal;
        this.tipoTarjeta = tipoTarjeta;
    }

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getUltimosDigitosTarjeta() {
        return ultimosDigitosTarjeta;
    }

    public void setUltimosDigitosTarjeta(String ultimosDigitosTarjeta) {
        this.ultimosDigitosTarjeta = ultimosDigitosTarjeta;
    }

    public String getCodigoQr() {
        return codigoQr;
    }

    public void setCodigoQr(String codigoQr) {
        this.codigoQr = codigoQr;
    }

    public MahnVisitante getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(MahnVisitante idVisitante) {
        this.idVisitante = idVisitante;
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
        hash += (idEntrada != null ? idEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnEntrada)) {
            return false;
        }
        MahnEntrada other = (MahnEntrada) object;
        if ((this.idEntrada == null && other.idEntrada != null) || (this.idEntrada != null && !this.idEntrada.equals(other.idEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MahnEntrada[ idEntrada=" + idEntrada + " ]";
    }
    
}
