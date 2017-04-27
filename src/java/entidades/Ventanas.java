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
@Table(name = "VENTANAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventanas.findAll", query = "SELECT v FROM Ventanas v")
    , @NamedQuery(name = "Ventanas.findByIdVentana", query = "SELECT v FROM Ventanas v WHERE v.idVentana = :idVentana")
    , @NamedQuery(name = "Ventanas.findByTitulo", query = "SELECT v FROM Ventanas v WHERE v.titulo = :titulo")
    , @NamedQuery(name = "Ventanas.findByUrl", query = "SELECT v FROM Ventanas v WHERE v.url = :url")
    , @NamedQuery(name = "Ventanas.findByPadre", query = "SELECT v FROM Ventanas v WHERE v.padre = :padre")
    , @NamedQuery(name = "Ventanas.findByOrden", query = "SELECT v FROM Ventanas v WHERE v.orden = :orden")
    , @NamedQuery(name = "Ventanas.findByEstado", query = "SELECT v FROM Ventanas v WHERE v.estado = :estado")
    , @NamedQuery(name = "Ventanas.findByUsuario", query = "SELECT v FROM Ventanas v WHERE v.usuario = :usuario")
    , @NamedQuery(name = "Ventanas.findByFecha", query = "SELECT v FROM Ventanas v WHERE v.fecha = :fecha")})
public class Ventanas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VENTANA")
    private Long idVentana;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "URL")
    private String url;
    @Column(name = "PADRE")
    private Integer padre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDEN")
    private int orden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "ID_APLICACION", referencedColumnName = "ID_APLICACION")
    @ManyToOne(optional = false)
    private Aplicaciones idAplicacion;
    @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
    @ManyToOne(optional = false)
    private Perfiles idPerfil;

    public Ventanas() {
    }

    public Ventanas(Long idVentana) {
        this.idVentana = idVentana;
    }

    public Ventanas(Long idVentana, String titulo, String url, int orden, String estado, String usuario, Date fecha) {
        this.idVentana = idVentana;
        this.titulo = titulo;
        this.url = url;
        this.orden = orden;
        this.estado = estado;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Long getIdVentana() {
        return idVentana;
    }

    public void setIdVentana(Long idVentana) {
        this.idVentana = idVentana;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPadre() {
        return padre;
    }

    public void setPadre(Integer padre) {
        this.padre = padre;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentana != null ? idVentana.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventanas)) {
            return false;
        }
        Ventanas other = (Ventanas) object;
        if ((this.idVentana == null && other.idVentana != null) || (this.idVentana != null && !this.idVentana.equals(other.idVentana))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Ventanas[ idVentana=" + idVentana + " ]";
    }
    
}
