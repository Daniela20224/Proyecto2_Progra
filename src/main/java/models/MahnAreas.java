/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Alison Espinoza
 */
@Entity
@Table(name = "MAHN_AREAS")

@SequenceGenerator(name = "areas_seq", sequenceName = "SEQ_MAHN_AREAS", allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = "MahnAreas.findAll", query = "SELECT m FROM MahnAreas m"),
    @NamedQuery(name = "MahnAreas.findByIdArea", query = "SELECT m FROM MahnAreas m WHERE m.idArea = :idArea"),
    @NamedQuery(name = "MahnAreas.findByNombre", query = "SELECT m FROM MahnAreas m WHERE m.nombre = :nombre")})
public class MahnAreas implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "areas_seq")
    @Basic(optional = false)
    @Column(name = "ID_AREA")
    private BigDecimal idArea;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;

    public MahnAreas() {
    }

    public MahnAreas(BigDecimal idArea) {
        this.idArea = idArea;
    }

    public MahnAreas(BigDecimal idArea, String nombre) {
        this.idArea = idArea;
        this.nombre = nombre;
    }

    public BigDecimal getIdArea() {
        return idArea;
    }

    public void setIdArea(BigDecimal idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnAreas)) {
            return false;
        }
        MahnAreas other = (MahnAreas) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MahnAreas[ idArea=" + idArea + " ]";
    }
    
}
