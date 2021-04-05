package com.xiangen.assignment.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.xiangen.assignment.models.Book;
import com.xiangen.assignment.services.BookService;

@Controller
public class BookController {
	
	private BookService bService;
	public BookController(BookService service) {
		this.bService = service;
	}
	
	// get all
	@GetMapping("/books")
		public String books(Model model) {
			List<Book> books = bService.getAllBooks();
			model.addAttribute("books", books);
			return "books.jsp";
		}
	
	// get one
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable Long id, Model model, @ModelAttribute("book") Book book) {
		Book oneBook = bService.findBookById(id);
		model.addAttribute("book", oneBook);
		return "book.jsp";
	}
	
	// create 
	@GetMapping("/books/add")
	public String addBook(@ModelAttribute("book") Book book) {
		return "add.jsp";
	}
	
	@PostMapping("/books/add")
		public String addBook(@ModelAttribute("book") Book book, BindingResult result) {
			if(result.hasErrors()) {
				return "add.jsp";
			} else {
				this.bService.createBook(book);
				return "redirect:/books";
			}
		}
	
	// edit, update
	@GetMapping(value="/books/edit/{id}")
		public String editBook(@PathVariable("id") Long id, Model model, @ModelAttribute("book") Book book) {
			Book oneBook = bService.findBookById(id);
			model.addAttribute("book", oneBook);
			return "edit.jsp";
			
		}
	
	@PostMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			bService.updateBook(book);
			return "redirect:/books";
		}
	}
	
	// delete
	@GetMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		this.bService.deleteBook(id);
		return "redirect:/books";
	}
}
