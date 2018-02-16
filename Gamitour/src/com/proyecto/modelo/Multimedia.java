package com.proyecto.modelo;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "multimedia", catalog = "gamitour")
public class Multimedia implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private int idmultimedia;
	private Cliente cliente;
	private Date fecha;
	private String comentario;
	private String imagen;
	private String video;
	private int pruebaDeportivaIdpruebadeportiva;
	private Integer puntosacumulados;
	private Set<Comentario> comentarios = new HashSet<Comentario>(0);
	private Set<Voto> votos = new HashSet<Voto>(0);

	public Multimedia() {
	}
	
	public Multimedia(Cliente cliente, Date fecha, String comentario, String imagen, String video,
			int pruebaDeportivaIdpruebadeportiva, Integer puntosacumulados) {
	
		this.cliente = cliente;
		this.fecha = fecha;
		this.comentario = comentario;
		this.imagen = imagen;
		this.video = video;
		this.pruebaDeportivaIdpruebadeportiva = pruebaDeportivaIdpruebadeportiva;
		this.puntosacumulados = puntosacumulados;
	}

	public Multimedia(int idmultimedia, Cliente cliente, Date fecha, String comentario, String imagen, String video,
			int pruebaDeportivaIdpruebadeportiva, Integer puntosacumulados, Set<Comentario> comentarios, Set<Voto> votos) {
		this.idmultimedia = idmultimedia;
		this.cliente = cliente;
		this.fecha = fecha;
		this.comentario = comentario;
		this.imagen = imagen;
		this.video = video;
		this.pruebaDeportivaIdpruebadeportiva = pruebaDeportivaIdpruebadeportiva;
		this.puntosacumulados = puntosacumulados;
		this.comentarios = comentarios;
		this.votos = votos;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Multimedia other = (Multimedia) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (idmultimedia != other.idmultimedia)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (pruebaDeportivaIdpruebadeportiva != other.pruebaDeportivaIdpruebadeportiva)
			return false;
		if (puntosacumulados == null) {
			if (other.puntosacumulados != null)
				return false;
		} else if (!puntosacumulados.equals(other.puntosacumulados))
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}

	@Id

	@Column(name = "idmultimedia", unique = true, nullable = false)
	public int getIdmultimedia() {
		return this.idmultimedia;
	}

	public void setIdmultimedia(int idmultimedia) {
		this.idmultimedia = idmultimedia;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_idcliente", nullable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", length = 10)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "comentario", length = 60)
	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Column(name = "imagen", length = 60)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Column(name = "video", length = 60)
	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@Column(name = "pruebaDeportiva_idpruebadeportiva", nullable = false)
	public int getPruebaDeportivaIdpruebadeportiva() {
		return this.pruebaDeportivaIdpruebadeportiva;
	}

	public void setPruebaDeportivaIdpruebadeportiva(int pruebaDeportivaIdpruebadeportiva) {
		this.pruebaDeportivaIdpruebadeportiva = pruebaDeportivaIdpruebadeportiva;
	}

	@Column(name = "puntosacumulados")
	public Integer getPuntosacumulados() {
		return this.puntosacumulados;
	}

	public void setPuntosacumulados(Integer puntosacumulados) {
		this.puntosacumulados = puntosacumulados;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "multimedia")
	public Set<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "multimedia")
	public Set<Voto> getVotos() {
		return this.votos;
	}

	public void setVotos(Set<Voto> votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Multimedia [cliente=" + cliente + ", comentario=" + comentario + ", imagen=" + imagen + ", video="
				+ video + ", pruebaDeportivaIdpruebadeportiva=" + pruebaDeportivaIdpruebadeportiva
				+ ", puntosacumulados=" + puntosacumulados + "]";
	}

}
