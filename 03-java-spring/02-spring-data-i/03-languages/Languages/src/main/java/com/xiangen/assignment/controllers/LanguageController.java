package com.xiangen.assignment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiangen.assignment.models.Language;
import com.xiangen.assignment.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
	private LanguageService bService;
	
	// get all
	@RequestMapping("/languages")
	public String languages(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = this.bService.getAll();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	// get one
	@GetMapping("/languages/{id}")
	public String showLan(@PathVariable("id") Long id, Model model, @ModelAttribute("language") Language language) {
		Language oneLan = this.bService.getOne(id);
		model.addAttribute("language", oneLan);
		return "language.jsp";
	}
	
	// create
	@PostMapping("/languages")
	public String addLan(@Valid  @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		this.bService.create(language);
		return "redirect:/languages";
	}
	
	// edit, update
	@GetMapping(value="/languages/edit/{id}")
	public String editLan(@PathVariable("id") Long id, Model model, @ModelAttribute("language") Language language) {
		Language oneLan = this.bService.getOne(id);
		model.addAttribute("language", oneLan);
		return "edit.jsp";
		
	}
	
	@PostMapping("/languages/edit/{id}")
	public String editBook(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			this.bService.update(language);
			return "redirect:/languages";
		}
	}
		
	// delete
	@GetMapping("/languages/delete/{id}")
	public String deleteLan(@PathVariable("id") Long id) {
		this.bService.delete(id);
		return "redirect:/languages";
	}
} 