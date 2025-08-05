package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	@Column(name = "forma_pago")
	private String formaPago;

	public Cliente() {
	}

	public Cliente(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Cliente(String nombre, String apellido, String formaPago) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.formaPago = formaPago;
	}

	public String getApellido() {
		return apellido;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cliente{" + "id=" + id + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\''
				+ ", formaPago='" + formaPago + '\'' + '}';
	}
}
