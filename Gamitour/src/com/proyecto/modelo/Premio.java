package com.proyecto.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;


@Entity
@Table(name = "premio", catalog = "gamitour")
public class Premio implements java.io.Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer idpremio;
	private Cliente cliente;
	@Expose
	private String nombre;
	@Expose
	private String descripcion;
	@Expose
	private String imagen;
	@Expose
	private Date fechaactivacion;
	@Expose
	private Date fechaconsumo;
	@Expose
	private Integer puntos;

	public Premio() {
	}

	public Premio(Cliente cliente) {
		this.cliente = cliente;
	}

	public Premio(Cliente cliente, String nombre, String descripcion, String imagen, Date fechaactivacion,
			Date fechaconsumo, Integer puntos) {
		this.cliente = cliente;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.fechaactivacion = fechaactivacion;
		this.fechaconsumo = fechaconsumo;
		this.puntos = puntos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idpremio", unique = true, nullable = false)
	public Integer getIdpremio() {
		return this.idpremio;
	}

	public void setIdpremio(Integer idpremio) {
		this.idpremio = idpremio;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_idcliente", nullable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Column(name = "nombre", length = 500)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", length = 500)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "imagen", length = 500)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaactivacion", length = 10)
	public Date getFechaactivacion() {
		return this.fechaactivacion;
	}

	public void setFechaactivacion(Date fechaactivacion) {
		this.fechaactivacion = fechaactivacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaconsumo", length = 10)
	public Date getFechaconsumo() {
		return this.fechaconsumo;
	}

	public void setFechaconsumo(Date fechaconsumo) {
		this.fechaconsumo = fechaconsumo;
	}

	@Column(name = "puntos")
	public Integer getPuntos() {
		return this.puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((puntos == null) ? 0 : puntos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Premio other = (Premio) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
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
		if (puntos == null) {
			if (other.puntos != null)
				return false;
		} else if (!puntos.equals(other.puntos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Premio [cliente=" + cliente + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", puntos=" + puntos + "]";
	}

}
