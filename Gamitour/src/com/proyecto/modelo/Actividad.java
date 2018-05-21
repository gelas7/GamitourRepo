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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;


@Entity
@Table(name = "actividad", catalog = "gamitour")
public class Actividad implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idactividad;
	@Expose
	private String nombre;
	@Expose
	private Date fechainicio;
	@Expose
	private Date fechafin;
	@Expose
	private String ubicacion;
	@Expose
	private Integer numparticipantes;
	@Expose
	private Float precio;
	@Expose
	private String imagen;
	@Expose
	private Integer puntos;

	private Set<Cliente> clientes = new HashSet<Cliente>(0);

	public Actividad() {
	}
	
	public Actividad(String nombre, Date fechainicio, Date fechafin, String ubicacion, Integer numparticipantes,
			Float precio, String imagen, Integer puntos) {
		this.nombre = nombre;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.ubicacion = ubicacion;
		this.numparticipantes = numparticipantes;
		this.precio = precio;
		this.imagen = imagen;
		this.puntos = puntos;
	}

	public Actividad(String nombre, Date fechainicio, Date fechafin, String ubicacion, Integer numparticipantes,
			Float precio, String imagen, Integer puntos, Set<Cliente> clientes) {
		this.nombre = nombre;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.ubicacion = ubicacion;
		this.numparticipantes = numparticipantes;
		this.precio = precio;
		this.imagen = imagen;
		this.puntos = puntos;
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "idactividad=" + idactividad + ", nombre=" + nombre + ", ubicacion=" + ubicacion
				+ ", numparticipantes=" + numparticipantes + ", precio=" + precio + ", imagen=" + imagen + ", puntos="
				+ puntos + "\n";
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividad other = (Actividad) obj;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numparticipantes == null) {
			if (other.numparticipantes != null)
				return false;
		} else if (!numparticipantes.equals(other.numparticipantes))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (puntos == null) {
			if (other.puntos != null)
				return false;
		} else if (!puntos.equals(other.puntos))
			return false;
		if (ubicacion == null) {
			if (other.ubicacion != null)
				return false;
		} else if (!ubicacion.equals(other.ubicacion))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idactividad", unique = true, nullable = false)
	public Integer getIdactividad() {
		return this.idactividad;
	}

	public void setIdactividad(Integer idactividad) {
		this.idactividad = idactividad;
	}

	@Column(name = "nombre", length = 60)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechainicio", length = 10)
	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechafin", length = 10)
	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	@Column(name = "ubicacion", length = 60)
	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Column(name = "numparticipantes")
	public Integer getNumparticipantes() {
		return this.numparticipantes;
	}

	public void setNumparticipantes(Integer numparticipantes) {
		this.numparticipantes = numparticipantes;
	}

	@Column(name = "precio", precision = 12, scale = 0)
	public Float getPrecio() {
		return this.precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	@Column(name = "imagen", length = 60)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Column(name = "puntos")
	public Integer getPuntos() {
		return this.puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cliente_has_actividad", catalog = "gamitour", joinColumns = {
			@JoinColumn(name = "actividad_idactividad", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "cliente_idcliente", nullable = false, updatable = false) })
	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

}
