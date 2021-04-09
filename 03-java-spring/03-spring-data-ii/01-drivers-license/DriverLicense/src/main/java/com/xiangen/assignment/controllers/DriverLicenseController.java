package com.xiangen.assignment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.xiangen.assignment.models.License;
import com.xiangen.assignment.models.Person;
import com.xiangen.assignment.services.DMVService;

@Controller
public class DriverLicenseController {
	@Autowired
	private DMVService dService;
	
	// index
	@GetMapping("/")
	public String index(Model model) {
		List<Person> persons = this.dService.getAllPersons();
		model.addAttribute("persons", persons);
		return "index.jsp";
	}
	
	// add new person
	@GetMapping("/persons/new")
	public String addPerson(@ModelAttribute("person") Person person) {
		return "addPerson.jsp";
	}
	
	@PostMapping("/persons/new")
	public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if( result.hasErrors()) {
			return "addPerson.jsp";
		}
		this.dService.createPerson(person);
		return "redirect:/";
	}
	
	// show person license information
	@GetMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", this.dService.getOnePerson(id));
		return "person.jsp";
	}
	
	// add new license
	@GetMapping("/licenses/new")
	public String addLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> unLicensedPersons = this.dService.getUnlicensedPeople();
		model.addAttribute("persons", unLicensedPersons);
//		model.addAttribute("persons", this.dService.getAllPersons());
		return "addLicense.jsp";
	}
	
	@PostMapping("/licenses/new")
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if( result.hasErrors()) {
			return "addLicense.jsp";
		}
		this.dService.createLicense(license);
		return "redirect:/";
	}
	
	// delete
	@GetMapping("/persons/delete/{id}")
	public String deletePerson(Long id) {
		this.dService.deletePerson(id);
		return "redirect:/";
	}
}
