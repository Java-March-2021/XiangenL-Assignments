package com.xiangen.assignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	private Boolean isCorrectCode(String code) {
		return code.equals("bushido");
	}
	private String[] getChracters() {
		return new String[] {
			"Loyalty", "Courage", "Veracity", "Compassion", "Honor"
		};
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
	@RequestMapping(path="/submit", method = RequestMethod.POST)
	public String submit(@RequestParam(value = "code") String code, RedirectAttributes redirectAttributes, Model model) {
		if(isCorrectCode(code)) {
			return "redirect:/code";
		}
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
	
	@RequestMapping("/code")
	public String code(Model model) {
		model.addAttribute("Chracters", getChracters());
		return "code.jsp";
	}
}
