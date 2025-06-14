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
@javax.persistence.Table(name = "MAHN_ENTRADA_SALA")

@SequenceGenerator(name = "entrada_salas_seq", sequenceName = "SEQ_MAHN_ENTRADA_SALAS", allocationSize = 1)
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "MahnEntradaSala.findAll", query = "SELECT m FROM MahnEntradaSala m"),
    @javax.persistence.NamedQuery(name = "MahnEntradaSala.findByIdEntradaSala", query = "SELECT m FROM MahnEntradaSala m WHERE m.idEntradaSala = :idEntradaSala"),
    @javax.persistence.NamedQuery(name = "MahnEntradaSala.findByFechaVisita", query = "SELECT m FROM MahnEntradaSala m WHERE m.fechaVisita = :fechaVisita"),
    @javax.persistence.NamedQuery(name = "MahnEntradaSala.findByEstadoAcceso", query = "SELECT m FROM MahnEntradaSala m WHERE m.estadoAcceso = :estadoAcceso")})
public class MahnEntradaSala implements Serializable {

    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entrada_salas_seq")
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID_ENTRADA_SALA")
    private Integer idEntradaSala;
    @javax.persistence.Column(name = "FECHA_VISITA")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaVisita;
    @javax.persistence.Column(name = "ESTADO_ACCESO")
    private String estadoAcceso;
    @javax.persistence.JoinColumn(name = "ID_ENTRADA", referencedColumnName = "ID_ENTRADA")
    @javax.persistence.ManyToOne(optional = false)
    private MahnEntrada idEntrada;
    @javax.persistence.JoinColumn(name = "ID_SALA", referencedColumnName = "ID_SALA")
    @javax.persistence.ManyToOne(optional = false)
    private MahnSala idSala;

    public MahnEntradaSala() {
    }

    public MahnEntradaSala(Integer idEntradaSala) {
        this.idEntradaSala = idEntradaSala;
    }

    public Integer getIdEntradaSala() {
        return idEntradaSala;
    }

    public void setIdEntradaSala(Integer idEntradaSala) {
        this.idEntradaSala = idEntradaSala;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getEstadoAcceso() {
        return estadoAcceso;
    }

    public void setEstadoAcceso(String estadoAcceso) {
        this.estadoAcceso = estadoAcceso;
    }

    public MahnEntrada getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(MahnEntrada idEntrada) {
        this.idEntrada = idEntrada;
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
        hash += (idEntradaSala != null ? idEntradaSala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnEntradaSala)) {
            return false;
        }
        MahnEntradaSala other = (MahnEntradaSala) object;
        if ((this.idEntradaSala == null && other.idEntradaSala != null) || (this.idEntradaSala != null && !this.idEntradaSala.equals(other.idEntradaSala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MahnEntradaSala[ idEntradaSala=" + idEntradaSala + " ]";
    }
    
}
