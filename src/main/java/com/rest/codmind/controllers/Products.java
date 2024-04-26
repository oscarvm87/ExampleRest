package com.rest.codmind.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.codmind.dtos.ProductsDTO;
import com.rest.codmind.models.Product;
import com.rest.codmind.services.ProductService;

@RestController
@RequestMapping("/products")
public class Products {

	@Autowired
	private ProductService productService;

	@GetMapping(value="/{productId}")
	public ResponseEntity<ProductsDTO> findById(@PathVariable("productId") Long productoId) {
		Product producto = productService.findById(productoId);
		ProductsDTO productoDTO = new ProductsDTO(
				producto.getId(),producto.getNombre(),producto.getPrecio());
		return new ResponseEntity<ProductsDTO>(productoDTO,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId){
		productService.deleteProduct(productId);
		return new ResponseEntity(HttpStatus.OK);		
	}	
	
	@GetMapping
	public ResponseEntity<List<Product>> findProduct(){
		List<Product> productos = productService.findAll();
		return new ResponseEntity<List<Product>>(productos,HttpStatus.OK);
	}

	@PostMapping(value="/product")
	public ResponseEntity<Product> postPtoduct(@RequestBody Product prod) {
		Product producto = productService.postPtoduct(prod);
		return new ResponseEntity<Product>(producto,HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Product> putProduct(@RequestBody Product prod) {
		Product producto = productService.putProduct(prod);
		return new ResponseEntity<Product>(producto,HttpStatus.OK);
	}	
	

	
}
