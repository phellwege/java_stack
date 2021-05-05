package com.peter.ninjadojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peter.ninjadojo.models.Dojo;
import com.peter.ninjadojo.models.Ninja;
import com.peter.ninjadojo.services.DojoService;
import com.peter.ninjadojo.services.NinjaService;



@Controller
public class MasterController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	public MasterController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	
	@RequestMapping("/dojo/new")
	public String home(@ModelAttribute("dojo") Dojo dojo) {
		return "index.jsp";
	}
	
	@RequestMapping("/newDojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo d, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		else {
			dojoService.createDojo(d);
		return "redirect:/ninja/new";
		}
	}
	
	@GetMapping("dojo/{dojoId}")
	public String showDojo(@PathVariable("dojoId") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "display.jsp";
		}
	
	@RequestMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja n, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "newNinja.jsp";
	}
	
	@RequestMapping("/newNinja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja j, BindingResult result) {
		if (result.hasErrors()) {
			return "newNinja.jsp";
		}
		else {
			ninjaService.createNinja(j);
		return "redirect:/ninja/new";
		}
	}
	
	
}
