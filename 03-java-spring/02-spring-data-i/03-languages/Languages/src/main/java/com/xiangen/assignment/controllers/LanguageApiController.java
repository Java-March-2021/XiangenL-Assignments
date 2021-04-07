package com.xiangen.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiangen.assignment.models.Language;
import com.xiangen.assignment.services.LanguageService;

@RestController
@RequestMapping("api")
public class LanguageApiController {
	@Autowired
	private LanguageService bService;
	
	// routes
	@RequestMapping("")
	public List<Language> index(){
		return this.bService.getAll();
	}
	
	// get one
	@RequestMapping("{id}")
	public Language getOneLan(@PathVariable("id") Long id) {
		return this.bService.getOne(id);
	}
	
	// create
	@RequestMapping(value = "/add/{id}", method = RequestMethod.PUT)
	public Language createLan(@PathVariable("id") Long id, Language newLan) {
		return this.bService.create(newLan);
	}
	
	// update
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public Language updateLan(@PathVariable("id") Long id, Language updatedLan) {
		return this.bService.create(updatedLan);
	}
	
	// delete
	public void destroy(@PathVariable("id") Long id) {
		this.bService.delete(id);
	}
	
}
