package com.xiangen.assignment.services;

import org.springframework.stereotype.Service;

import com.xiangen.assignment.models.Book;
import com.xiangen.assignment.repositories.BookRepository;

@Service
public class BookService {
	private BookRepository bRepo;
	public BookService(BookRepository repo) {
		this.bRepo = repo;
	}

	public Book getOneBook(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
}
