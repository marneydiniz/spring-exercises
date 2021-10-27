package br.com.marney.springexercises.controllers;

import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marney.springexercises.model.entities.Product;
import br.com.marney.springexercises.model.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Product saveProduct(@Valid Product product) {
		productRepository.save(product);
		return product;
	}
	
	@GetMapping
	public Iterable<Product> findProduct() {
		return productRepository.findAll();
	}
	
	@GetMapping(path = "/name/{text}")
	public Iterable<Product> findProductsByName(@PathVariable String text) {
		return productRepository.findByNameContainingIgnoreCase(text);
	}
	
	@GetMapping(path = "/page/{pageNumber}/{totalPages}")
	public Iterable<Product> findProductsByPage(@PathVariable int pageNumber, @PathVariable int totalPages){
		if(totalPages >= 5) {
			totalPages = 5;
			}
		Pageable page = PageRequest.of(pageNumber, totalPages);
		return productRepository.findAll(page);
	}
	
	@GetMapping("/{id}")
	public Optional<Product> findProductById(@PathVariable int id) {
		return productRepository.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable int id) {
		productRepository.deleteById(id);
	}
}
