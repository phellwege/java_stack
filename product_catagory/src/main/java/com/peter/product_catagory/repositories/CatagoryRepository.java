package com.peter.product_catagory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.peter.product_catagory.models.Catagory;

public interface CatagoryRepository extends CrudRepository<Catagory, Long> {
	List<Catagory> findAll();
	void deleteById(Long id);
}
