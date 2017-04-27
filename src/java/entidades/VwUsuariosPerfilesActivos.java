/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mar
 */
@Entity
@Table(name = "VW_USUARIOS_PERFILES_ACTIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwUsuariosPerfilesActivos.findAll", query = "SELECT v FROM VwUsuariosPerfilesActivos v")
    , @NamedQuery(name = "VwUsuariosPerfilesActivos.findByIdUsuario", query = "SELECT v FROM VwUsuariosPerfilesActivos v WHERE v.idUsuario = :idUsuario")
    , @NamedQuery(name = "VwUsuariosPerfilesActivos.findByUsuarioLogin", query = "SELECT v FROM VwUsuariosPerfilesActivos v WHERE v.usuarioLogin = :usuarioLogin")
    , @NamedQuery(name = "VwUsuariosPerfilesActivos.findByNombre", query = "SELECT v FROM VwUsuariosPerfilesActivos v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "VwUsuariosPerfilesActivos.findByCorreo", query = "SELECT v FROM VwUsuariosPerfilesActivos v WHERE v.correo = :correo")
    , @NamedQuery(name = "VwUsuariosPerfilesActivos.findByRdhCodigo", query = "SELECT v FROM VwUsuariosPerfilesActivos v WHERE v.rdhCodigo = :rdhCodigo")
    , @NamedQuery(name = "VwUsuariosPerfilesActivos.findByRegional", query = "SELECT v FROM VwUsuariosPerfilesActivos v WHERE v.regional = :regional")
    , @NamedQuery(name = "VwUsuariosPerfilesActivos.findByIdArea", query = "SELECT v FROM VwUsuariosPerfilesActivos v WHERE v.idArea = :idArea")
    , @NamedQuery(name = "VwUsuariosPerfilesActivos.findByArea", query = "SELECT v FROM VwUsuariosPerfilesActivos v WHERE v.area = :area")
    , @NamedQuery(name = "VwUsuariosPerfilesActivos.findByIdPerfil", query = "SELECT v FROM VwUsuariosPerfilesActivos v WHERE v.idPerfil = :idPerfil")
    , @NamedQuery(name = "VwUsuariosPerfilesActivos.findByPerfil", query = "SELECT v FROM VwUsuariosPerfilesActivos v WHERE v.perfil = :perfil")
    , @NamedQuery(name = "VwUsuariosPerfilesActivos.findByIdAplicacion", query = "SELECT v FROM VwUsuariosPerfilesActivos v WHERE v.idAplicacion = :idAplicacion")
    , @NamedQuery(name = "VwUsuariosPerfilesActivos.findByAplicacion", query = "SELECT v FROM VwUsuariosPerfilesActivos v WHERE v.aplicacion = :aplicacion")})
public class VwUsuariosPerfilesActivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    @Id
    private long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USUARIO_LOGIN")
    private String usuarioLogin;
    @Size(max = 501)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "RDH_CODIGO")
    private String rdhCodigo;
    @Size(max = 64)
    @Column(name = "REGIONAL")
    private String regional;
    @Column(name = "ID_AREA")
    private BigInteger idArea;
    @Size(max = 100)
    @Column(name = "AREA")
    private String area;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERFIL")
    private long idPerfil;
    @Size(max = 50)
    @Column(name = "PERFIL")
    private String perfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_APLICACION")
    private int idAplicacion;
    @Size(max = 100)
    @Column(name = "APLICACION")
    private String aplicacion;

    public VwUsuariosPerfilesActivos() {
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRdhCodigo() {
        return rdhCodigo;
    }

    public void setRdhCodigo(String rdhCodigo) {
        this.rdhCodigo = rdhCodigo;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public BigInteger getIdArea() {
        return idArea;
    }

    public void setIdArea(BigInteger idArea) {
        this.idArea = idArea;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(int idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }
    
}
