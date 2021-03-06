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

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "parada", catalog = "gamitour")
public class Parada implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Expose
	private int idparada;
	
	private Itinerario itinerario;
	@Expose
	private String nombre;
	@Expose
	private Integer numeroParada;
	@Expose
	private String ubicacion;
	@Expose
	private String historia;
	@Expose
	private String anecdotario;
	@Expose
	private String gastronomia;
	@Expose
	private String imagen;
	@Expose
	private String video;
	@Expose
	private Set<PruebaCultural> pruebaculturales = new HashSet<PruebaCultural>(0);
	@Expose
	private Set<PruebaDeportiva> pruebadeportivas = new HashSet<PruebaDeportiva>(0);
	@Expose
	private Float latitud;
	@Expose
	private Float longitud;

	public Parada() {
	}

	public Parada(int idparada, Itinerario itinerario) {
		this.idparada = idparada;
		this.itinerario = itinerario;
	}

	public Parada(Itinerario itinerario, String nombre, Integer numeroParada, String ubicacion, String historia,
			String anecdotario, String gastronomia, String imagen,String video, Float latitud, Float longitud) {
		this.itinerario = itinerario;
		this.nombre = nombre;
		this.numeroParada = numeroParada;
		this.ubicacion = ubicacion;
		this.historia = historia;
		this.anecdotario = anecdotario;
		this.gastronomia = gastronomia;
		this.imagen = imagen;
		this.video = video;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Parada [idparada=" + idparada + ", itinerario=" + itinerario + ", nombre=" + nombre + ", numeroParada="
				+ numeroParada + ", ubicacion=" + ubicacion + ", historia=" + historia + ", anecdotario=" + anecdotario
				+ ", gastronomia=" + gastronomia + ", imagen=" + imagen +", video=" + video + "]";
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

	@Column(name = "nombre", length = 500)
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

	@Column(name = "ubicacion", length = 500)
	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Column(name = "historia", length = 500)
	public String getHistoria() {
		return this.historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	@Column(name = "anecdotario", length = 500)
	public String getAnecdotario() {
		return this.anecdotario;
	}

	public void setAnecdotario(String anecdotario) {
		this.anecdotario = anecdotario;
	}

	@Column(name = "gastronomia", length = 500)
	public String getGastronomia() {
		return this.gastronomia;
	}

	public void setGastronomia(String gastronomia) {
		this.gastronomia = gastronomia;
	}

	@Column(name = "imagen", length = 500)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Column(name = "video", length = 500)
	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
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
	
	@Column(name = "latitud")
	public Float getLatitud() {
		return latitud;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}
	
	@Column(name = "longitud")
	public Float getLongitud() {
		return longitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anecdotario == null) ? 0 : anecdotario.hashCode());
		result = prime * result + ((gastronomia == null) ? 0 : gastronomia.hashCode());
		result = prime * result + ((historia == null) ? 0 : historia.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
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
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}
}
