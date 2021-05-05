package com.peter.product_catagory.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.peter.product_catagory.models.Catagory;
import com.peter.product_catagory.models.Product;
import com.peter.product_catagory.services.CatagoryService;
import com.peter.product_catagory.services.ProductService;


@Controller
public class MasterController {
	private final ProductService productService;
	private final CatagoryService catagoryService;
	public MasterController(ProductService productService, CatagoryService catagoryService) {
	this.productService = productService;
	this.catagoryService = catagoryService;
	}
	
	@RequestMapping("/newProd")
	public String prodHome(@ModelAttribute("product") Product product) {
		return "NewProduct.jsp";
	}
	
	@RequestMapping("/createProd")
	public String createProd(@Valid @ModelAttribute("product") Product p, BindingResult result) {
		if (result.hasErrors()) {
			return "NewProduct.jsp";
		}
		else {
			productService.createProd(p);
		return "redirect:/newProd";
		}
	}
	
	@RequestMapping("/newCat")
	public String catHome(@ModelAttribute("catagory") Catagory catagory) {
		return "NewCatagory.jsp";
	}
	
	@RequestMapping("/createCat")
	public String createCat(@Valid @ModelAttribute("catagory") Catagory c, BindingResult result) {
		if (result.hasErrors()) {
			return "NewCatagory.jsp";
		}
		else {
			catagoryService.createCat(c);
		return "redirect:/newCat";
		}
	}
	
	@RequestMapping(value = "/product/{id}", method=RequestMethod.GET)
	public String showProd(@PathVariable("id") Long id, Model model ) {
		Product product = productService.findProd(id);
		List<Catagory> catagories = catagoryService.allCats();
		model.addAttribute("product", product);
		model.addAttribute("catagories", catagories);
		return "ShowProduct.jsp";
	}
	
	@GetMapping("/catagory/{id}")
	public String showCat(@PathVariable("id") Long id, Model model) {
		Catagory catagory = catagoryService.findCat(id);
		List<Product> products = productService.allProd();
		model.addAttribute("catagory", catagory);
		model.addAttribute("products", products);
		return "ShowCatagory.jsp";
	}
	@PostMapping("/add/{id}")
	public String createRelationnship(@PathVariable("id")Long id, @RequestParam("catagory") Long CatId) {
		Product product = productService.findProd(id);
		Catagory catagory = catagoryService.findCat(CatId);
		product.getCatagories().add(catagory);
		productService.createProd(product);
		return "redirect:/product/{id}";
	}
	@PostMapping("/make/{id}")
	public String makeRelationnship(@PathVariable("id")Long id, @RequestParam("product") Long ProdId) {
		Catagory catagory = catagoryService.findCat(id);
		Product product = productService.findProd(ProdId);
		catagory.getProducts().add(product);
		catagoryService.createCat(catagory);
		return "redirect:/catagory/{id}";
	}
}
