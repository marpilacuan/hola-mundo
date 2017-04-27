/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mar
 */
@Entity
@Table(name = "PERFILES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfiles.findAll", query = "SELECT p FROM Perfiles p")
    , @NamedQuery(name = "Perfiles.findByIdPerfil", query = "SELECT p FROM Perfiles p WHERE p.idPerfil = :idPerfil")
    , @NamedQuery(name = "Perfiles.findByDescripcion", query = "SELECT p FROM Perfiles p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Perfiles.findByActivo", query = "SELECT p FROM Perfiles p WHERE p.activo = :activo")
    , @NamedQuery(name = "Perfiles.findBySoloLectura", query = "SELECT p FROM Perfiles p WHERE p.soloLectura = :soloLectura")
    , @NamedQuery(name = "Perfiles.findByUsuario", query = "SELECT p FROM Perfiles p WHERE p.usuario = :usuario")
    , @NamedQuery(name = "Perfiles.findByFecha", query = "SELECT p FROM Perfiles p WHERE p.fecha = :fecha")})
public class Perfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERFIL")
    private Long idPerfil;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ACTIVO")
    private Short activo;
    @Column(name = "SOLO_LECTURA")
    private Short soloLectura;
    @Size(max = 20)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private Collection<RelAplicaciones> relAplicacionesCollection;
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID_APLICACION")
    @ManyToOne
    private Aplicaciones idAplicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private Collection<Ventanas> ventanasCollection;

    public Perfiles() {
    }

    public Perfiles(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
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

    public Short getSoloLectura() {
        return soloLectura;
    }

    public void setSoloLectura(Short soloLectura) {
        this.soloLectura = soloLectura;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<RelAplicaciones> getRelAplicacionesCollection() {
        return relAplicacionesCollection;
    }

    public void setRelAplicacionesCollection(Collection<RelAplicaciones> relAplicacionesCollection) {
        this.relAplicacionesCollection = relAplicacionesCollection;
    }

    public Aplicaciones getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Aplicaciones idAplicacion) {
        this.idAplicacion = idAplicacion;
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
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfiles)) {
            return false;
        }
        Perfiles other = (Perfiles) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Perfiles[ idPerfil=" + idPerfil + " ]";
    }
    
}
