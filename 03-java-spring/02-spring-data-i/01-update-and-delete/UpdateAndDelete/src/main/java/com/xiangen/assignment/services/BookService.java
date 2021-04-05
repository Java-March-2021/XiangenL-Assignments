package com.xiangen.assignment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xiangen.assignment.models.Book;
import com.xiangen.assignment.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bRepo;
	
	public BookService(BookRepository repo) {
		this.bRepo = repo;
	}

	//get all
	public List<Book> getAllBooks() {
		return this.bRepo.findAll();
	}
	
	//get one
	public Book findBookById(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
	
	//create
	public Book createBook(Book newBook) {
		return this.bRepo.save(newBook);
	}
	
	// update
	public Book updateBook(Book updatedBook) {
		return this.bRepo.save(updatedBook);
	}
	
	// delete
	public void deleteBook(Long id) {
		this.bRepo.deleteById(id);
	}
}
