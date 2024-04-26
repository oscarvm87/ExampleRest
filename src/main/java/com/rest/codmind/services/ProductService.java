package com.rest.codmind.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.codmind.models.Product;
import com.rest.codmind.repository.ProductRepository;
import com.rest.codmind.validaciones.ProductValidacion;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	public Product findById(Long productoId) {
		Product producto = productRepo.findById(productoId)
				.orElseThrow(() -> new RuntimeException("No existe el producto"));
		return producto;
	}
	
	@Transactional
	public void deleteProduct(Long productId){
		Product producto = productRepo.findById(productId)
				.orElseThrow(() -> new RuntimeException("No existe el producto"));
		productRepo.delete(producto);		
	}
	
	public List<Product> findAll() {
		List<Product> productos = productRepo.findAll();
		return productos;
	}
	

	@Transactional
	public Product postPtoduct(Product prod) {
		ProductValidacion.save(prod);
		
		Product producto = productRepo.save(prod);
		return producto;
	}
	
	public Product putProduct(Product prod) {
		Product producto = productRepo.findById(prod.getId())
				.orElseThrow(() -> new RuntimeException("No existe el producto"));
		
		producto.setNombre(prod.getNombre());
		producto.setPrecio(prod.getPrecio());
		productRepo.save(producto);
		
		return producto;
	}	
	

}
