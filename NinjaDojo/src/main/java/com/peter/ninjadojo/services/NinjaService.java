package com.peter.ninjadojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.peter.ninjadojo.models.Dojo;
import com.peter.ninjadojo.models.Ninja;
import com.peter.ninjadojo.repositories.NinjaRepository;


	@Service
	public class NinjaService {
		private final NinjaRepository ninjaRepository;
		
		private NinjaService(NinjaRepository ninjaRepository) {
			this.ninjaRepository = ninjaRepository;
		}
		
		public List<Ninja> allNinjas() {
			return ninjaRepository.findAll();
		}
		public Ninja createNinja(Ninja j) {
			return ninjaRepository.save(j);
		}
		
		public Ninja findNinja(Long id) {
			Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
			if(optionalNinja.isPresent()) {
				return optionalNinja.get();
			} else {
				return null;
			}
		}
		public Ninja updateNinja(Long id, String firstName, String lastName, String age) {
			Ninja ninja = findNinja(id);
			ninja.setFirstName(firstName);
			ninja.setLastName(lastName);
			ninja.setAge(age);
			return ninjaRepository.save(ninja);
		}
		public void deleteNinja(Long id) {
			ninjaRepository.deleteById(id);
		}
}
