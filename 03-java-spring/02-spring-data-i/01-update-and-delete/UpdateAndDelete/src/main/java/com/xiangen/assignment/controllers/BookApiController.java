package com.xiangen.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiangen.assignment.models.Book;
import com.xiangen.assignment.services.BookService;

@RestController
@RequestMapping("api")
public class BookApiController {
	@Autowired
	private BookService bService;
	
	@RequestMapping("/")
	public List<Book> index() {
		return this.bService.getAllBooks();
	}
	
	@RequestMapping("/{id}")
	public Book getOneBook(@PathVariable("id") Long id) {
		return this.bService.findBookById(id);
	}
	
	@RequestMapping(value="/books/add/{id}", method=RequestMethod.PUT)
	public Book addBook(@PathVariable("id") Long id, Book newbook) {
	return this.bService.createBook(newbook);
	}
	
	@RequestMapping(value="/books/edit/{id}", method=RequestMethod.PUT)	
	public Book update(@PathVariable("id") Long id, Book updatedBook) {
        return this.bService.updateBook(updatedBook);
    }
    
    @DeleteMapping(value="/books/delete/{id}")
    public void destroy(@PathVariable("id") Long id) {
        this.bService.deleteBook(id);
    }
	
}
