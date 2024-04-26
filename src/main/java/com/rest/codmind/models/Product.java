package com.rest.codmind.models;

import javax.persistence.*;

@Entity
@Table(name="Products")
public class Product {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre",nullable = false,length = 100)
	private String nombre;
	
	@Column(name="precio",nullable = false)
	private Double precio;
	
	public Product() {}
	
	public Product(Long id, String nombre, Double precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return "name" + nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
