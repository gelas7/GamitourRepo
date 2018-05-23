package com.proyecto.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "noticia", catalog = "gamitour")
public class Noticia implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idnoticia;
	@Expose
	private String nombre;
	@Expose
	private String texto;
	@Expose
	private Date fechaalta;
	@Expose
	private Date fechacaducidad;
	@Expose
	private String imagen;

	public Noticia() {
	}

	public Noticia(String nombre, String texto, Date fechaalta, Date fechacaducidad, String imagen) {
		this.nombre = nombre;
		this.texto = texto;
		this.fechaalta = fechaalta;
		this.fechacaducidad = fechacaducidad;
		this.imagen = imagen;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idnoticia", unique = true, nullable = false)
	public Integer getIdnoticia() {
		return this.idnoticia;
	}

	public void setIdnoticia(Integer idnoticia) {
		this.idnoticia = idnoticia;
	}

	@Column(name = "nombre", length = 500)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "texto", length = 500)
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaalta", length = 10)
	public Date getFechaalta() {
		return this.fechaalta;
	}

	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechacaducidad", length = 10)
	public Date getFechacaducidad() {
		return this.fechacaducidad;
	}

	public void setFechacaducidad(Date fechacaducidad) {
		this.fechacaducidad = fechacaducidad;
	}

	@Column(name = "imagen", length = 500)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idnoticia == null) ? 0 : idnoticia.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
		Noticia other = (Noticia) obj;
		if (idnoticia == null) {
			if (other.idnoticia != null)
				return false;
		} else if (!idnoticia.equals(other.idnoticia))
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
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Noticia [nombre=" + nombre + ", texto=" + texto + ", imagen=" + imagen + "]";
	}

}
