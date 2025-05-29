/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Alison Espinoza
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "MAHN_PRECIOS")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "MahnPrecios.findAll", query = "SELECT m FROM MahnPrecios m"),
    @javax.persistence.NamedQuery(name = "MahnPrecios.findById", query = "SELECT m FROM MahnPrecios m WHERE m.id = :id"),
    @javax.persistence.NamedQuery(name = "MahnPrecios.findByPrecioLunesASabado", query = "SELECT m FROM MahnPrecios m WHERE m.precioLunesASabado = :precioLunesASabado"),
    @javax.persistence.NamedQuery(name = "MahnPrecios.findByPrecioDomingo", query = "SELECT m FROM MahnPrecios m WHERE m.precioDomingo = :precioDomingo")})
public class MahnPrecios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID")
    private Integer id;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "PRECIO_LUNES_A_SABADO")
    private Integer precioLunesASabado;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "PRECIO_DOMINGO")
    private Integer precioDomingo;
    @javax.persistence.JoinColumn(name = "ID_SALA", referencedColumnName = "ID_SALA")
    @javax.persistence.ManyToOne(optional = false)
    private MahnSala idSala;

    public MahnPrecios() {
    }

    public MahnPrecios(Integer id) {
        this.id = id;
    }

    public MahnPrecios(Integer id, Integer precioLunesASabado, Integer precioDomingo) {
        this.id = id;
        this.precioLunesASabado = precioLunesASabado;
        this.precioDomingo = precioDomingo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrecioLunesASabado() {
        return precioLunesASabado;
    }

    public void setPrecioLunesASabado(Integer precioLunesASabado) {
        this.precioLunesASabado = precioLunesASabado;
    }

    public Integer getPrecioDomingo() {
        return precioDomingo;
    }

    public void setPrecioDomingo(Integer precioDomingo) {
        this.precioDomingo = precioDomingo;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnPrecios)) {
            return false;
        }
        MahnPrecios other = (MahnPrecios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MahnPrecios[ id=" + id + " ]";
    }
    
    public int getPrecio(){
    return this.precioLunesASabado;
    
    }
    
}
