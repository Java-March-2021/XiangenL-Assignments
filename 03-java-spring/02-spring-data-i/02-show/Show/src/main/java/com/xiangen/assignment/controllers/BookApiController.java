package com.xiangen.assignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiangen.assignment.services.BookService;

@Controller
@RequestMapping("books")
public class BookApiController {
	
	private BookService bService;
	public BookApiController(BookService service) {
		this.bService = service;
	}

	
	@GetMapping("{id}")
	public String showBook(@PathVariable Long id, Model model) {
		model.addAttribute("book", this.bService.getOneBook(id));
		return "book.jsp";
	}
}
