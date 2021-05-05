package com.peter.ninjadojo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.peter.ninjadojo.models.Dojo;
import com.peter.ninjadojo.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	private DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	public Dojo updateDojo(Long id, String name) {
		Dojo dojo = findDojo(id);
		dojo.setName(name);
		return dojoRepository.save(dojo);
	}
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
	
}
