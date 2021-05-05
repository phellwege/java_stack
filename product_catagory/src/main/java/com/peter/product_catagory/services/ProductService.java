package com.peter.product_catagory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.peter.product_catagory.models.Product;
import com.peter.product_catagory.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	private ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> allProd() {
		return productRepository.findAll();
	}
	public Product createProd(Product p) {
		return productRepository.save(p);
	}
	
	public Product findProd(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public Product updateProd(Long id, String name, String description, double price) {
		Product product = findProd(id);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		return productRepository.save(product);
	}
	
	public void deleteProd(Long id) {
		productRepository.deleteById(id);
	}
	
}
