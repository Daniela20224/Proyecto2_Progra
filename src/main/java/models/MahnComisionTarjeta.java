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
@javax.persistence.Table(name = "MAHN_COMISION_TARJETA")

@SequenceGenerator(name = "comision_tarjeta_seq", sequenceName = "SEQ_MAHN_COMISION_TARJETA", allocationSize = 1)
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "MahnComisionTarjeta.findAll", query = "SELECT m FROM MahnComisionTarjeta m"),
    @javax.persistence.NamedQuery(name = "MahnComisionTarjeta.findByIdComision", query = "SELECT m FROM MahnComisionTarjeta m WHERE m.idComision = :idComision"),
    @javax.persistence.NamedQuery(name = "MahnComisionTarjeta.findByTipoTarjeta", query = "SELECT m FROM MahnComisionTarjeta m WHERE m.tipoTarjeta = :tipoTarjeta"),
    @javax.persistence.NamedQuery(name = "MahnComisionTarjeta.findByComision", query = "SELECT m FROM MahnComisionTarjeta m WHERE m.comision = :comision")})
public class MahnComisionTarjeta implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comision_tarjeta_seq")
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID_COMISION")
    private Integer idComision;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "TIPO_TARJETA")
    private String tipoTarjeta;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "COMISION")
    private Integer comision;

    public MahnComisionTarjeta() {
    }

    public MahnComisionTarjeta(Integer idComision) {
        this.idComision = idComision;
    }

    public MahnComisionTarjeta(Integer idComision, String tipoTarjeta, Integer comision) {
        this.idComision = idComision;
        this.tipoTarjeta = tipoTarjeta;
        this.comision = comision;
    }

    public Integer getIdComision() {
        return idComision;
    }

    public void setIdComision(Integer idComision) {
        this.idComision = idComision;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Integer getComision() {
        return comision;
    }

    public void setComision(Integer comision) {
        this.comision = comision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComision != null ? idComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnComisionTarjeta)) {
            return false;
        }
        MahnComisionTarjeta other = (MahnComisionTarjeta) object;
        if ((this.idComision == null && other.idComision != null) || (this.idComision != null && !this.idComision.equals(other.idComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MahnComisionTarjeta[ idComision=" + idComision + " ]";
    }
    
}
