package com.xiangen.assignment.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xiangen.assignment.models.User;
import com.xiangen.assignment.services.UserService;
import com.xiangen.assignment.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator uValidator;
	
	@GetMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registration.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		this.uValidator.validate(user, result);
		if(result.hasErrors()) {
			return "registration.jsp";
		}
		User newUser = this.uService.registration(user);
		session.setAttribute("user__id", newUser.getId());
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("loginEmail") String email, @RequestParam("loginPassword") String password, RedirectAttributes redirectAttrs, Model model, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			model.addAttribute("loginError", "Invalid Credentials");
			return "login.jsp";
		}
		User user = this.uService.findByEmail(email);
		session.setAttribute("user__id", user.getId());
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String index(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user__id");
		User user = this.uService.findById(userId);
		model.addAttribute("user", user);
		return "index.jsp";	
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
