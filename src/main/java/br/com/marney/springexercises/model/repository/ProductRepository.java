package br.com.marney.springexercises.model.repository;

//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.marney.springexercises.model.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
	public Iterable<Product> findByNameContainingIgnoreCase(String text);
	
//	findByNameContaining
//	findByNameIsContaining
//	findByNameContains
//	
//	findByNameStartsWith
//	findByNameEndsWith
//	
//	findByNameNotContaining
	
//	@Query("SELECT p FROM Product p WHERE o.name LIKE %:name%")
//	public Iterable<Product> searchByNameLike(@Param("name") String name);

}
