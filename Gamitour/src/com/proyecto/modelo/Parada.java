package com.proyecto.modelo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parada", catalog = "gamitour")
public class Parada implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idparada;
	private Itinerario itinerario;
	private String nombre;
	private Integer numeroParada;
	private String ubicacion;
	private String historia;
	private String anecdotario;
	private String gastronomia;
	private String imagen;
	private Set<PruebaCultural> pruebaculturales = new HashSet<PruebaCultural>(0);
	private Set<PruebaDeportiva> pruebadeportivas = new HashSet<PruebaDeportiva>(0);

	public Parada() {
	}

	public Parada(int idparada, Itinerario itinerario) {
		this.idparada = idparada;
		this.itinerario = itinerario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anecdotario == null) ? 0 : anecdotario.hashCode());
		result = prime * result + ((gastronomia == null) ? 0 : gastronomia.hashCode());
		result = prime * result + ((historia == null) ? 0 : historia.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((itinerario == null) ? 0 : itinerario.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numeroParada == null) ? 0 : numeroParada.hashCode());
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
		Parada other = (Parada) obj;
		if (anecdotario == null) {
			if (other.anecdotario != null)
				return false;
		} else if (!anecdotario.equals(other.anecdotario))
			return false;
		if (gastronomia == null) {
			if (other.gastronomia != null)
				return false;
		} else if (!gastronomia.equals(other.gastronomia))
			return false;
		if (historia == null) {
			if (other.historia != null)
				return false;
		} else if (!historia.equals(other.historia))
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (itinerario == null) {
			if (other.itinerario != null)
				return false;
		} else if (!itinerario.equals(other.itinerario))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroParada == null) {
			if (other.numeroParada != null)
				return false;
		} else if (!numeroParada.equals(other.numeroParada))
			return false;
		if (ubicacion == null) {
			if (other.ubicacion != null)
				return false;
		} else if (!ubicacion.equals(other.ubicacion))
			return false;
		return true;
	}

	public Parada(int idparada, Itinerario itinerario, String nombre, Integer numeroParada, String ubicacion,
			String historia, String anecdotario, String gastronomia, String imagen,
			Set<PruebaCultural> pruebaculturales, Set<PruebaDeportiva> pruebadeportivas) {
		this.idparada = idparada;
		this.itinerario = itinerario;
		this.nombre = nombre;
		this.numeroParada = numeroParada;
		this.ubicacion = ubicacion;
		this.historia = historia;
		this.anecdotario = anecdotario;
		this.gastronomia = gastronomia;
		this.imagen = imagen;
		this.pruebaculturales = pruebaculturales;
		this.pruebadeportivas = pruebadeportivas;
	}

	public Parada(Itinerario itinerario, String nombre, Integer numeroParada, String ubicacion, String historia,
			String anecdotario, String gastronomia, String imagen) {
		this.itinerario = itinerario;
		this.nombre = nombre;
		this.numeroParada = numeroParada;
		this.ubicacion = ubicacion;
		this.historia = historia;
		this.anecdotario = anecdotario;
		this.gastronomia = gastronomia;
		this.imagen = imagen;
	}

	@Id

	@Column(name = "idparada", unique = true, nullable = false)
	public int getIdparada() {
		return this.idparada;
	}

	public void setIdparada(int idparada) {
		this.idparada = idparada;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "itinerario_iditinerario", nullable = false)
	public Itinerario getItinerario() {
		return this.itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	@Column(name = "nombre", length = 60)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "numeroParada")
	public Integer getNumeroParada() {
		return this.numeroParada;
	}

	public void setNumeroParada(Integer numeroParada) {
		this.numeroParada = numeroParada;
	}

	@Column(name = "ubicacion", length = 45)
	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Column(name = "historia", length = 200)
	public String getHistoria() {
		return this.historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	@Column(name = "anecdotario", length = 200)
	public String getAnecdotario() {
		return this.anecdotario;
	}

	public void setAnecdotario(String anecdotario) {
		this.anecdotario = anecdotario;
	}

	@Column(name = "gastronomia", length = 200)
	public String getGastronomia() {
		return this.gastronomia;
	}

	public void setGastronomia(String gastronomia) {
		this.gastronomia = gastronomia;
	}

	@Column(name = "imagen", length = 45)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parada")
	public Set<PruebaCultural> getPruebaculturals() {
		return this.pruebaculturales;
	}

	public void setPruebaculturals(Set<PruebaCultural> pruebaculturals) {
		this.pruebaculturales = pruebaculturals;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parada")
	public Set<PruebaDeportiva> getPruebadeportivas() {
		return this.pruebadeportivas;
	}

	public void setPruebadeportivas(Set<PruebaDeportiva> pruebadeportivas) {
		this.pruebadeportivas = pruebadeportivas;
	}

}
