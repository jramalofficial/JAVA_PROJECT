package com.ukf.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ukf.demo.model.Product;
import com.ukf.demo.service.ProductService;
@RestController
public class ProductController {
	@Autowired
	public ProductService service;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return service.getAllProduct();
	
	}
	
//	@PostMapping("/products")
//	public Optional<Product> getProductById(int id){
//		return service.getProductById(id);
//	}
	@PostMapping("/product")
	public String addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	@GetMapping("/product/{id}")
	   public Product getProductById(@PathVariable int id) {
	       return service.getProductById(id);
	   }

	   @DeleteMapping("/product/{id}")
	   public String deleteProductById(@PathVariable int id) {
	       return service.deleteProductById(id);
	   }

	   @PutMapping("/product/{id}")
	   public String updateProductById(@PathVariable int id, @RequestBody Product product) {
	       return service.updateProductById(id, product);
	   }
	   
}
