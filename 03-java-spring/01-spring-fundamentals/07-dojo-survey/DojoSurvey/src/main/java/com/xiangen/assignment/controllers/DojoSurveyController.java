package com.xiangen.assignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiangen.assignment.models.Survey;


@Controller
public class DojoSurveyController {
	
	private String[] getLocations() {
		return new String[] {
				"C#", "Java", "Python", "C++"
		};
	}
	
	private String[] getLanguages() {
		return new String[] {
				"Seattle", "Chicago", "Dallas", "San Jose", "Tulsa"
		};
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("locations", getLocations());
		model.addAttribute("languages", getLanguages());
		return "index.jsp";
	}
	
	@RequestMapping("/result")
	public String showResult(Model model) {

		return "result.jsp";
	}
	
	@RequestMapping(path="/result", method=RequestMethod.POST)
	public String result(Model model, @RequestParam("name") String name, @RequestParam("location") String location, @RequestParam("language") String  language, @RequestParam(value="comment", required = false) String comment) {
//		model.addAttribute("name", name);
//		model.addAttribute("location", location);
//		model.addAttribute("language", language);
//		model.addAttribute("comment", comment);
		model.addAttribute("result", new Survey(name, location, language, comment));
		return "result.jsp";
	}
}
