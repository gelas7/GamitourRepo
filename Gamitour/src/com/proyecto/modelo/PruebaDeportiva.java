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
@Table(name = "pruebaDeportiva", catalog = "gamitour")
public class PruebaDeportiva implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Expose
	private Integer idpruebadeportiva;
	private Parada parada;
	@Expose
	private String nombre;
	@Expose
	private Date fechainicio;
	@Expose
	private Date fechafin;
	@Expose
	private String explicacion;
	@Expose
	private Integer puntos;

	public PruebaDeportiva() {
	}


	public PruebaDeportiva(Parada parada, String nombre, Date fechainicio, Date fechafin, String explicacion,
			Integer puntos) {
		this.parada = parada;
		this.nombre = nombre;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.explicacion = explicacion;
		this.puntos = puntos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((explicacion == null) ? 0 : explicacion.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((parada == null) ? 0 : parada.hashCode());
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
		PruebaDeportiva other = (PruebaDeportiva) obj;
		if (explicacion == null) {
			if (other.explicacion != null)
				return false;
		} else if (!explicacion.equals(other.explicacion))
			return false;
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
		if (puntos == null) {
			if (other.puntos != null)
				return false;
		} else if (!puntos.equals(other.puntos))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idpruebadeportiva", unique = true, nullable = false)
	public Integer getIdpruebadeportiva() {
		return this.idpruebadeportiva;
	}

	public void setIdpruebadeportiva(Integer idpruebadeportiva) {
		this.idpruebadeportiva = idpruebadeportiva;
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

	@Column(name = "explicacion", length = 500)
	public String getExplicacion() {
		return this.explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	@Column(name = "puntos")
	public Integer getPuntos() {
		return this.puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}


}
