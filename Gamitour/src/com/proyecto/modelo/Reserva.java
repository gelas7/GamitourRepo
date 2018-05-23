package com.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;


@Entity
@Table(name = "reserva", catalog = "gamitour")
public class Reserva implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idreserva;
	private Cliente cliente;
	private Actividad actividad;
	
	@Expose
	private Date fecha;

	@Expose
	private String comentarios;

	public Reserva() {
	}

	public Reserva(Cliente cliente, Actividad actividad, String comentarios, Date fecha) {
		this.cliente = cliente;
		this.actividad = actividad;
		this.comentarios = comentarios;
		this.fecha = fecha;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idreserva", unique = true, nullable = false)
	public Integer getIdreserva() {
		return this.idreserva;
	}

	public void setIdreserva(Integer idreserva) {
		this.idreserva = idreserva;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_idcliente", nullable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "actividad_idactividad", nullable = false)
	public Actividad getActividad() {
		return this.actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", length = 10)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Column(name = "comentarios", length = 500)
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentarios == null) ? 0 : comentarios.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
		Reserva other = (Reserva) obj;
		if (comentarios == null) {
			if (other.comentarios != null)
				return false;
		} else if (!comentarios.equals(other.comentarios))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reserva [cliente=" + cliente + ", actividad=" + actividad + ", fecha=" + fecha + ", comentarios="
				+ comentarios + "]";
	}


}
