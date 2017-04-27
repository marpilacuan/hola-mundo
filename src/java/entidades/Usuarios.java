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
@Table(name = "USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuarios.findByUsuarioLogin", query = "SELECT u FROM Usuarios u WHERE u.usuarioLogin = :usuarioLogin")
    , @NamedQuery(name = "Usuarios.findByContrasena", query = "SELECT u FROM Usuarios u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuarios.findByNombres", query = "SELECT u FROM Usuarios u WHERE u.nombres = :nombres")
    , @NamedQuery(name = "Usuarios.findByTipoUsuario", query = "SELECT u FROM Usuarios u WHERE u.tipoUsuario = :tipoUsuario")
    , @NamedQuery(name = "Usuarios.findByBloqueado", query = "SELECT u FROM Usuarios u WHERE u.bloqueado = :bloqueado")
    , @NamedQuery(name = "Usuarios.findByActivo", query = "SELECT u FROM Usuarios u WHERE u.activo = :activo")
    , @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "Usuarios.findByFechaEvento", query = "SELECT u FROM Usuarios u WHERE u.fechaEvento = :fechaEvento")
    , @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuarios.findByCodigoActorSicohi", query = "SELECT u FROM Usuarios u WHERE u.codigoActorSicohi = :codigoActorSicohi")
    , @NamedQuery(name = "Usuarios.findByRucActorSicohi", query = "SELECT u FROM Usuarios u WHERE u.rucActorSicohi = :rucActorSicohi")
    , @NamedQuery(name = "Usuarios.findByNombreEmpresaSicohi", query = "SELECT u FROM Usuarios u WHERE u.nombreEmpresaSicohi = :nombreEmpresaSicohi")
    , @NamedQuery(name = "Usuarios.findByRegional", query = "SELECT u FROM Usuarios u WHERE u.regional = :regional")
    , @NamedQuery(name = "Usuarios.findByCorreoAdicional", query = "SELECT u FROM Usuarios u WHERE u.correoAdicional = :correoAdicional")
    , @NamedQuery(name = "Usuarios.findByTipoIdentif", query = "SELECT u FROM Usuarios u WHERE u.tipoIdentif = :tipoIdentif")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USUARIO_LOGIN")
    private String usuarioLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 100)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIPO_USUARIO")
    private String tipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BLOQUEADO")
    private short bloqueado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO")
    private short activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_EVENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 20)
    @Column(name = "CODIGO_ACTOR_SICOHI")
    private String codigoActorSicohi;
    @Size(max = 13)
    @Column(name = "RUC_ACTOR_SICOHI")
    private String rucActorSicohi;
    @Size(max = 200)
    @Column(name = "NOMBRE_EMPRESA_SICOHI")
    private String nombreEmpresaSicohi;
    @Size(max = 3)
    @Column(name = "REGIONAL")
    private String regional;
    @Size(max = 100)
    @Column(name = "CORREO_ADICIONAL")
    private String correoAdicional;
    @Size(max = 1)
    @Column(name = "TIPO_IDENTIF")
    private String tipoIdentif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<RelAplicaciones> relAplicacionesCollection;
    @JoinColumn(name = "ID_AREA", referencedColumnName = "ID_AREA")
    @ManyToOne
    private Area idArea;

    public Usuarios() {
    }

    public Usuarios(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Long idUsuario, String usuarioLogin, String contrasena, String apellidos, String tipoUsuario, short bloqueado, short activo, String usuario, Date fechaEvento, String correo) {
        this.idUsuario = idUsuario;
        this.usuarioLogin = usuarioLogin;
        this.contrasena = contrasena;
        this.apellidos = apellidos;
        this.tipoUsuario = tipoUsuario;
        this.bloqueado = bloqueado;
        this.activo = activo;
        this.usuario = usuario;
        this.fechaEvento = fechaEvento;
        this.correo = correo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public short getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(short bloqueado) {
        this.bloqueado = bloqueado;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigoActorSicohi() {
        return codigoActorSicohi;
    }

    public void setCodigoActorSicohi(String codigoActorSicohi) {
        this.codigoActorSicohi = codigoActorSicohi;
    }

    public String getRucActorSicohi() {
        return rucActorSicohi;
    }

    public void setRucActorSicohi(String rucActorSicohi) {
        this.rucActorSicohi = rucActorSicohi;
    }

    public String getNombreEmpresaSicohi() {
        return nombreEmpresaSicohi;
    }

    public void setNombreEmpresaSicohi(String nombreEmpresaSicohi) {
        this.nombreEmpresaSicohi = nombreEmpresaSicohi;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getCorreoAdicional() {
        return correoAdicional;
    }

    public void setCorreoAdicional(String correoAdicional) {
        this.correoAdicional = correoAdicional;
    }

    public String getTipoIdentif() {
        return tipoIdentif;
    }

    public void setTipoIdentif(String tipoIdentif) {
        this.tipoIdentif = tipoIdentif;
    }

    @XmlTransient
    public Collection<RelAplicaciones> getRelAplicacionesCollection() {
        return relAplicacionesCollection;
    }

    public void setRelAplicacionesCollection(Collection<RelAplicaciones> relAplicacionesCollection) {
        this.relAplicacionesCollection = relAplicacionesCollection;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
