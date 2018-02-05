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


@Entity
@Table(name = "voto", catalog = "gamitour")
public class Voto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idvoto;
	private Cliente cliente;
	private Multimedia multimedia;
	private Integer puntos;

	public Voto() {
	}

	public Voto(Cliente cliente, Multimedia multimedia) {
		this.cliente = cliente;
		this.multimedia = multimedia;
	}

	@Override
	public String toString() {
		return "Voto [cliente=" + cliente + ", multimedia=" + multimedia + ", puntos=" + puntos + "]";
	}

	public Voto(Cliente cliente, Multimedia multimedia, Integer puntos) {
		this.cliente = cliente;
		this.multimedia = multimedia;
		this.puntos = puntos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idvoto", unique = true, nullable = false)
	public Integer getIdvoto() {
		return this.idvoto;
	}

	public void setIdvoto(Integer idvoto) {
		this.idvoto = idvoto;
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
	@JoinColumn(name = "multimedia_idmultimedia", nullable = false)
	public Multimedia getMultimedia() {
		return this.multimedia;
	}

	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
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
		result = prime * result + ((multimedia == null) ? 0 : multimedia.hashCode());
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
		Voto other = (Voto) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (multimedia == null) {
			if (other.multimedia != null)
				return false;
		} else if (!multimedia.equals(other.multimedia))
			return false;
		if (puntos == null) {
			if (other.puntos != null)
				return false;
		} else if (!puntos.equals(other.puntos))
			return false;
		return true;
	}

}
