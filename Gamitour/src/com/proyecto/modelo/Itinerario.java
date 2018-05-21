package com.proyecto.modelo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "itinerario", catalog = "gamitour")
public class Itinerario implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer iditinerario;
	@Expose
	private String nombre;
	@Expose
	private String categoria;
	@Expose
	private Integer duracion;
	@Expose
	private String ubicacion;
	@Expose
	private Set<Parada> paradas = new HashSet<Parada>(0);

	public Itinerario() {
	}

	public Itinerario(String nombre, String categoria, Integer duracion, String ubicacion, Set<Parada> paradas) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.duracion = duracion;
		this.ubicacion = ubicacion;
		this.paradas = paradas;
	}

	public Itinerario(String nombre, String categoria, Integer duracion, String ubicacion) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.duracion = duracion;
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Itinerario [iditinerario=" + iditinerario + ", nombre=" + nombre + ", categoria=" + categoria
				+ ", duracion=" + duracion + ", ubicacion=" + ubicacion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "iditinerario", unique = true, nullable = false)
	public Integer getIditinerario() {
		return this.iditinerario;
	}

	public void setIditinerario(Integer iditinerario) {
		this.iditinerario = iditinerario;
	}

	@Column(name = "nombre", length = 60)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "categoria", length = 45)
	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Column(name = "duracion", length = 4)
	public Integer getDuracion() {
		return this.duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	@Column(name = "ubicacion", length = 45)
	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "itinerario")
	public Set<Parada> getParadas() {
		return this.paradas;
	}

	public void setParadas(Set<Parada> paradas) {
		this.paradas = paradas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
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
		Itinerario other = (Itinerario) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (ubicacion == null) {
			if (other.ubicacion != null)
				return false;
		} else if (!ubicacion.equals(other.ubicacion))
			return false;
		return true;
	}

}
