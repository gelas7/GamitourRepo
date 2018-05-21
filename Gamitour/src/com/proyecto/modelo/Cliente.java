package com.proyecto.modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "cliente", catalog = "gamitour")
public class Cliente implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idcliente;
	private Rol rol;
	@Expose
	private String nombre;
	@Expose
	private String apellidos;
	@Expose
	private Date fechanacimiento;
	@Expose
	private String email;
	private String password;
	@Expose
	private String telefono;
	@Expose
	private String direccion;
	@Expose
	private String codigopostal;
	@Expose
	private String avatar;
	@Expose
	private Integer puntosacumulados;
	@Expose
	private Date fecharegistro;
	@Expose
	private Set<Premio> premios = new HashSet<Premio>(0);
	@Expose
	private Set<Voto> votos = new HashSet<Voto>(0);
	@Expose
	private Set<Comentario> comentarios = new HashSet<Comentario>(0);
	@Expose
	private Set<Actividad> actividades = new HashSet<Actividad>(0);
	@Expose
	private Set<Multimedia> multimedias = new HashSet<Multimedia>(0);

	public Cliente() {
	}

	public Cliente(Rol rol) {
		this.rol = rol;
	}

	public Cliente(Rol rol, String nombre, String apellidos, Date fechanacimiento, String email, String password,
			String telefono, String direccion, String codigopostal, String avatar, Integer puntosacumulados,
			Date fecharegistro) {
		this.rol = rol;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechanacimiento = fechanacimiento;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codigopostal = codigopostal;
		this.avatar = avatar;
		this.puntosacumulados = puntosacumulados;
		this.fecharegistro = fecharegistro;

	}

	public Cliente(Rol rol, String nombre, String apellidos, Date fechanacimiento, String email, String password,
			String telefono, String direccion, String codigopostal, String avatar, Integer puntosacumulados,
			Date fecharegistro, Set<Premio> premios, Set<Voto> votos, Set<Comentario> comentarios,
			Set<Actividad> actividades, Set<Multimedia> multimedias) {
		this.rol = rol;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechanacimiento = fechanacimiento;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codigopostal = codigopostal;
		this.avatar = avatar;
		this.puntosacumulados = puntosacumulados;
		this.fecharegistro = fecharegistro;
		this.premios = premios;
		this.votos = votos;
		this.comentarios = comentarios;
		this.actividades = actividades;
		this.multimedias = multimedias;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idcliente", unique = true, nullable = false)
	public Integer getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rol_idrol", nullable = false)
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Column(name = "nombre", length = 60)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellidos", length = 60)
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechanacimiento", length = 10)
	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "telefono", length = 45)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "direccion", length = 60)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "codigopostal", length = 10)
	public String getCodigopostal() {
		return this.codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	@Column(name = "avatar", length = 45)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "puntosacumulados")
	public Integer getPuntosacumulados() {
		return this.puntosacumulados;
	}

	public void setPuntosacumulados(Integer puntosacumulados) {
		this.puntosacumulados = puntosacumulados;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecharegistro", length = 10)
	public Date getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	public Set<Premio> getPremios() {
		return this.premios;
	}

	public void setPremios(Set<Premio> premios) {
		this.premios = premios;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	public Set<Voto> getVotos() {
		return this.votos;
	}

	public void setVotos(Set<Voto> votos) {
		this.votos = votos;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	public Set<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cliente_has_actividad", catalog = "gamitour", joinColumns = {
			@JoinColumn(name = "cliente_idcliente", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "actividad_idactividad", nullable = false, updatable = false) })
	public Set<Actividad> getActividades() {
		return this.actividades;
	}

	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	public Set<Multimedia> getMultimedias() {
		return this.multimedias;
	}

	public void setMultimedias(Set<Multimedia> multimedias) {
		this.multimedias = multimedias;
	}

	@Override
	public String toString() {
		return "Cliente [rol=" + rol + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", password=" + password + ", telefono=" + telefono + ", direccion=" + direccion + ", codigopostal="
				+ codigopostal + ", avatar=" + avatar + ", puntosacumulados=" + puntosacumulados + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (codigopostal == null) {
			if (other.codigopostal != null)
				return false;
		} else if (!codigopostal.equals(other.codigopostal))
			return false;
		if (comentarios == null) {
			if (other.comentarios != null)
				return false;
		} else if (!comentarios.equals(other.comentarios))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (puntosacumulados == null) {
			if (other.puntosacumulados != null)
				return false;
		} else if (!puntosacumulados.equals(other.puntosacumulados))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

}
