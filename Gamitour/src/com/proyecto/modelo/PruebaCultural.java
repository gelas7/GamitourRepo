package com.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "pruebaCultural", catalog = "gamitour")
public class PruebaCultural implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idpruebacultural;
	private Parada parada;
	@Expose
	private String nombre;
	@Expose
	private String pregunta;
	@Expose
	private String respuesta;
	@Expose
	private String respuesta2;
	@Expose
	private String respuesta3;

	@Expose
	private Integer puntos;

	public PruebaCultural() {
	}

	public PruebaCultural(Parada parada) {
		this.parada = parada;
	}

	public PruebaCultural(Parada parada, String nombre, String pregunta, String respuesta, String respuesta2,
			String respuesta3, Integer puntos) {
		this.parada = parada;
		this.nombre = nombre;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.respuesta2 = respuesta2;
		this.respuesta3 = respuesta3;
		this.puntos = puntos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idpruebacultural", unique = true, nullable = false)
	public Integer getIdpruebacultural() {
		return this.idpruebacultural;
	}

	public void setIdpruebacultural(Integer idpruebacultural) {
		this.idpruebacultural = idpruebacultural;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parada_idparada", nullable = false)
	public Parada getParada() {
		return this.parada;
	}

	public void setParada(Parada parada) {
		this.parada = parada;
	}

	@Column(name = "nombre", length = 500)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "pregunta", length = 500)
	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	@Column(name = "respuesta", length = 500)
	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Column(name = "respuesta2", length = 500)
	public String getRespuesta2() {
		return this.respuesta2;
	}

	public void setRespuesta2(String respuesta2) {
		this.respuesta2 = respuesta2;
	}

	@Column(name = "respuesta3", length = 500)
	public String getRespuesta3() {
		return this.respuesta3;
	}

	public void setRespuesta3(String respuesta3) {
		this.respuesta3 = respuesta3;
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
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((parada == null) ? 0 : parada.hashCode());
		result = prime * result + ((pregunta == null) ? 0 : pregunta.hashCode());
		result = prime * result + ((puntos == null) ? 0 : puntos.hashCode());
		result = prime * result + ((respuesta == null) ? 0 : respuesta.hashCode());
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
		PruebaCultural other = (PruebaCultural) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (parada == null) {
			if (other.parada != null)
				return false;
		} else if (!parada.equals(other.parada))
			return false;
		if (pregunta == null) {
			if (other.pregunta != null)
				return false;
		} else if (!pregunta.equals(other.pregunta))
			return false;
		if (puntos == null) {
			if (other.puntos != null)
				return false;
		} else if (!puntos.equals(other.puntos))
			return false;
		if (respuesta == null) {
			if (other.respuesta != null)
				return false;
		} else if (!respuesta.equals(other.respuesta))
			return false;
		return true;
	}

}
