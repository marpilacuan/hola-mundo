/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mar
 */
@Entity
@Table(name = "APLICACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aplicaciones.findAll", query = "SELECT a FROM Aplicaciones a")
    , @NamedQuery(name = "Aplicaciones.findByIdAplicacion", query = "SELECT a FROM Aplicaciones a WHERE a.idAplicacion = :idAplicacion")
    , @NamedQuery(name = "Aplicaciones.findByNombreAplicacion", query = "SELECT a FROM Aplicaciones a WHERE a.nombreAplicacion = :nombreAplicacion")
    , @NamedQuery(name = "Aplicaciones.findByDescripcion", query = "SELECT a FROM Aplicaciones a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Aplicaciones.findByActivo", query = "SELECT a FROM Aplicaciones a WHERE a.activo = :activo")
    , @NamedQuery(name = "Aplicaciones.findByUrl", query = "SELECT a FROM Aplicaciones a WHERE a.url = :url")})
public class Aplicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_APLICACION")
    private Integer idAplicacion;
    @Size(max = 40)
    @Column(name = "NOMBRE_APLICACION")
    private String nombreAplicacion;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ACTIVO")
    private Short activo;
    @Size(max = 100)
    @Column(name = "URL")
    private String url;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAplicacion")
    private Collection<RelAplicaciones> relAplicacionesCollection;
    @OneToMany(mappedBy = "idAplicacion")
    private Collection<Perfiles> perfilesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAplicacion")
    private Collection<Ventanas> ventanasCollection;

    public Aplicaciones() {
    }

    public Aplicaciones(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public Integer getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public String getNombreAplicacion() {
        return nombreAplicacion;
    }

    public void setNombreAplicacion(String nombreAplicacion) {
        this.nombreAplicacion = nombreAplicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public Collection<RelAplicaciones> getRelAplicacionesCollection() {
        return relAplicacionesCollection;
    }

    public void setRelAplicacionesCollection(Collection<RelAplicaciones> relAplicacionesCollection) {
        this.relAplicacionesCollection = relAplicacionesCollection;
    }

    @XmlTransient
    public Collection<Perfiles> getPerfilesCollection() {
        return perfilesCollection;
    }

    public void setPerfilesCollection(Collection<Perfiles> perfilesCollection) {
        this.perfilesCollection = perfilesCollection;
    }

    @XmlTransient
    public Collection<Ventanas> getVentanasCollection() {
        return ventanasCollection;
    }

    public void setVentanasCollection(Collection<Ventanas> ventanasCollection) {
        this.ventanasCollection = ventanasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAplicacion != null ? idAplicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplicaciones)) {
            return false;
        }
        Aplicaciones other = (Aplicaciones) object;
        if ((this.idAplicacion == null && other.idAplicacion != null) || (this.idAplicacion != null && !this.idAplicacion.equals(other.idAplicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Aplicaciones[ idAplicacion=" + idAplicacion + " ]";
    }
    
}
