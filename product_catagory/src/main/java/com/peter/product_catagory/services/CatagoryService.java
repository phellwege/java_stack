package com.peter.product_catagory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.peter.product_catagory.models.Catagory;
import com.peter.product_catagory.repositories.CatagoryRepository;

@Service
public class CatagoryService {
	private final CatagoryRepository catagoryRepository;
	
	private CatagoryService(CatagoryRepository catagoryRepository) {
		this.catagoryRepository = catagoryRepository;
	}
	public List<Catagory> allCats() {
		return catagoryRepository.findAll();
	}
	public Catagory createCat(Catagory c) {
		return catagoryRepository.save(c);
	}
	public Catagory findCat(Long id) {
		Optional<Catagory> optionalCatagory = catagoryRepository.findById(id);
		if(optionalCatagory.isPresent()) {
			return optionalCatagory.get();
		} else {
			return null;
		}
	}
	public Catagory updateCat(Long id, String name) {
		Catagory catagory = findCat(id);
		catagory.setName(name);
		return catagoryRepository.save(catagory);
	}
	public void deleteCat(Long id) {
		catagoryRepository.deleteById(id);
	}
}
