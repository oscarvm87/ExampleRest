package com.rest.codmind.validaciones;

import com.rest.codmind.models.Product;

public class ProductValidacion {

	public static void save(Product producto) {
		
		if(producto.getNombre() == null || producto.getNombre().trim().isEmpty())
			throw new RuntimeException("El nombre es obligatorio.");
		
		if(producto.getNombre().length() > 50)
			throw new RuntimeException("El nombre es muy largo (max 50).");
	
		if(producto.getPrecio() == null)
			throw new RuntimeException("El precio es obligatorio.");
		
		if(producto.getPrecio() < 0)
			throw new RuntimeException("El precio es incorrecto.");
	}
}
