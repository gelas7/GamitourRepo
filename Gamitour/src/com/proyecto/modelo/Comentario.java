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
@Table(name = "comentario", catalog = "gamitour")
public class Comentario implements java.io.Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer idcomentario;
	private Cliente cliente;
	private Multimedia multimedia;
	@Expose
	private String texto;

	public Comentario() {
	}

	public Comentario(Cliente cliente, Multimedia multimedia) {
		this.cliente = cliente;
		this.multimedia = multimedia;
	}


	public Comentario(Cliente cliente, Multimedia multimedia, String texto) {
		this.cliente = cliente;
		this.multimedia = multimedia;
		this.texto = texto;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idcomentario", unique = true, nullable = false)
	public Integer getIdcomentario() {
		return this.idcomentario;
	}

	public void setIdcomentario(Integer idcomentario) {
		this.idcomentario = idcomentario;
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

	@Column(name = "texto", length = 500)
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((multimedia == null) ? 0 : multimedia.hashCode());
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
		Comentario other = (Comentario) obj;
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
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [cliente=" + cliente + ", multimedia=" + multimedia + ", texto=" + texto + "]";
	}
}
