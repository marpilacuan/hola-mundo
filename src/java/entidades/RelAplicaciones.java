/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mar
 */
@Entity
@Table(name = "REL_APLICACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelAplicaciones.findAll", query = "SELECT r FROM RelAplicaciones r")
    , @NamedQuery(name = "RelAplicaciones.findByIdRelApp", query = "SELECT r FROM RelAplicaciones r WHERE r.idRelApp = :idRelApp")
    , @NamedQuery(name = "RelAplicaciones.findByEstado", query = "SELECT r FROM RelAplicaciones r WHERE r.estado = :estado")
    , @NamedQuery(name = "RelAplicaciones.findByFechaAcceso", query = "SELECT r FROM RelAplicaciones r WHERE r.fechaAcceso = :fechaAcceso")
    , @NamedQuery(name = "RelAplicaciones.findByUsuario", query = "SELECT r FROM RelAplicaciones r WHERE r.usuario = :usuario")})
public class RelAplicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REL_APP")
    private Long idRelApp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ACCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAcceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USUARIO")
    private String usuario;
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID_APLICACION")
    @ManyToOne(optional = false)
    private Aplicaciones idAplicacion;
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfiles idPerfil;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public RelAplicaciones() {
    }

    public RelAplicaciones(Long idRelApp) {
        this.idRelApp = idRelApp;
    }

    public RelAplicaciones(Long idRelApp, String estado, Date fechaAcceso, String usuario) {
        this.idRelApp = idRelApp;
        this.estado = estado;
        this.fechaAcceso = fechaAcceso;
        this.usuario = usuario;
    }

    public Long getIdRelApp() {
        return idRelApp;
    }

    public void setIdRelApp(Long idRelApp) {
        this.idRelApp = idRelApp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(Date fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Aplicaciones getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Aplicaciones idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public Perfiles getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfiles idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelApp != null ? idRelApp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelAplicaciones)) {
            return false;
        }
        RelAplicaciones other = (RelAplicaciones) object;
        if ((this.idRelApp == null && other.idRelApp != null) || (this.idRelApp != null && !this.idRelApp.equals(other.idRelApp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.RelAplicaciones[ idRelApp=" + idRelApp + " ]";
    }
    
}
