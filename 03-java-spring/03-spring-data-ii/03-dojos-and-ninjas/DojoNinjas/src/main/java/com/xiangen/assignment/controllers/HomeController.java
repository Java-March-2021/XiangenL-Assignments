package com.xiangen.assignment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.xiangen.assignment.models.Dojo;
import com.xiangen.assignment.models.Ninja;
import com.xiangen.assignment.services.DojoNinjaService;

@Controller
public class HomeController {
	@Autowired
	private DojoNinjaService dService;
	
	// index
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("dojos", this.dService.getAllDojo());
		return "index.jsp";
	}
	
	// get one dojo
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model dModel, Model nModel) {
		dModel.addAttribute("dojo", this.dService.getOneDojo(id));
		nModel.addAttribute("ninjas", this.dService.getAllNinja());
		return "showDojo.jsp";
	}
	
	// new dojo
	@GetMapping("/dojos/new")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "addDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "addDojo.jsp";
		}
		this.dService.createDojo(dojo);
		return "redirect:/";
	}
	
	// new ninja
	@GetMapping("/ninjas/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, Model dModel) {
		dModel.addAttribute("dojos", this.dService.getAllDojo());
		return "addNinja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model dModel) {
		if(result.hasErrors()) {
			dModel.addAttribute("dojos", this.dService.getAllDojo());
			return "addNinja.jsp";
		}
		this.dService.createNinja(ninja);
		return "redirect:/";
	}
	
	// delete dojo
	@GetMapping("/dojos/delete/{id}")
	public String deleteDojo(@PathVariable("id") Long id) {
		this.dService.delete(id);
		return "redirect:/";
	}
}
