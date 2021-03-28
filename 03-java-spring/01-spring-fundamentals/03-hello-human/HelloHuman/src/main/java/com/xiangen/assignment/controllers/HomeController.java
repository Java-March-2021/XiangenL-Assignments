package com.xiangen.assignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(@RequestParam(value = "firstname", defaultValue = "Human") String firstname, @RequestParam(value = "lastname", required = false) String lastname, Model model) {
		model.addAttribute("firstname", firstname);
		model.addAttribute("lastname", lastname);
		System.out.println(lastname);
		return "index.jsp";
	}
}
