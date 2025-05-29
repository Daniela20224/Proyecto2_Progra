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
@javax.persistence.Table(name = "MAHN_VISITANTE")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "MahnVisitante.findAll", query = "SELECT m FROM MahnVisitante m"),
    @javax.persistence.NamedQuery(name = "MahnVisitante.findByIdVisitante", query = "SELECT m FROM MahnVisitante m WHERE m.idVisitante = :idVisitante"),
    @javax.persistence.NamedQuery(name = "MahnVisitante.findByNombre", query = "SELECT m FROM MahnVisitante m WHERE m.nombre = :nombre"),
    @javax.persistence.NamedQuery(name = "MahnVisitante.findByApellido", query = "SELECT m FROM MahnVisitante m WHERE m.apellido = :apellido"),
    @javax.persistence.NamedQuery(name = "MahnVisitante.findByDocumentoIdentidad", query = "SELECT m FROM MahnVisitante m WHERE m.documentoIdentidad = :documentoIdentidad"),
    @javax.persistence.NamedQuery(name = "MahnVisitante.findByCorreoElectronico", query = "SELECT m FROM MahnVisitante m WHERE m.correoElectronico = :correoElectronico"),
    @javax.persistence.NamedQuery(name = "MahnVisitante.findByTelefono", query = "SELECT m FROM MahnVisitante m WHERE m.telefono = :telefono"),
    @javax.persistence.NamedQuery(name = "MahnVisitante.findByFechaRegistro", query = "SELECT m FROM MahnVisitante m WHERE m.fechaRegistro = :fechaRegistro")})
public class MahnVisitante implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "ID_VISITANTE")
    private Integer idVisitante;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "NOMBRE")
    private String nombre;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "APELLIDO")
    private String apellido;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "DOCUMENTO_IDENTIDAD")
    private String documentoIdentidad;
    @javax.persistence.Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @javax.persistence.Column(name = "TELEFONO")
    private String telefono;
    @javax.persistence.Column(name = "FECHA_REGISTRO")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "idVisitante")
    private Collection<MahnEntrada> mahnEntradaCollection;

    public MahnVisitante() {
    }

    public MahnVisitante(Integer idVisitante) {
        this.idVisitante = idVisitante;
    }

    public MahnVisitante(Integer idVisitante, String nombre, String apellido, String documentoIdentidad) {
        this.idVisitante = idVisitante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documentoIdentidad = documentoIdentidad;
    }

    public Integer getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Integer idVisitante) {
        this.idVisitante = idVisitante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Collection<MahnEntrada> getMahnEntradaCollection() {
        return mahnEntradaCollection;
    }

    public void setMahnEntradaCollection(Collection<MahnEntrada> mahnEntradaCollection) {
        this.mahnEntradaCollection = mahnEntradaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisitante != null ? idVisitante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahnVisitante)) {
            return false;
        }
        MahnVisitante other = (MahnVisitante) object;
        if ((this.idVisitante == null && other.idVisitante != null) || (this.idVisitante != null && !this.idVisitante.equals(other.idVisitante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.MahnVisitante[ idVisitante=" + idVisitante + " ]";
    }
    
}
