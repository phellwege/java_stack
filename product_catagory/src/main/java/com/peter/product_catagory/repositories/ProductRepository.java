package com.peter.product_catagory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.peter.product_catagory.models.Product;



public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	void deleteById(Long id);
}
