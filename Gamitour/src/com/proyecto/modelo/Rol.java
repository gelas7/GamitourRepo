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


@Entity
@Table(name = "rol", catalog = "gamitour")
public class Rol implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer idrol;
	private String nombre;
	private Set<Cliente> clientes = new HashSet<Cliente>(0);

	public Rol() {
	}

	public Rol(String nombre, Set<Cliente> clientes) {
		this.nombre = nombre;
		this.clientes = clientes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idrol", unique = true, nullable = false)
	public Integer getIdrol() {
		return this.idrol;
	}

	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	@Column(name = "nombre", length = 500)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "rol")
	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public String toString() {
		return "Rol [idrol=" + idrol + ", nombre=" + nombre + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Rol other = (Rol) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}



}
