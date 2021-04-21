package com.xiangen.assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangen.assignment.models.Category;
import com.xiangen.assignment.models.Product;
import com.xiangen.assignment.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	public List<Category> allCategories(){
	return this.cRepo.findAll();
	}
	
	public Category getOneCategory(Long id) {
		Category category = this.cRepo.findById(id).orElse(null);
		return category;
	}
	
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	public List<Category> categoryNotContain(Product product){
		return this.cRepo.findByProductsNotContaining(product);
	}
}
