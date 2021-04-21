package com.xiangen.assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangen.assignment.models.Category;
import com.xiangen.assignment.models.Product;
import com.xiangen.assignment.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	
	public List<Product> allProducts(){
		return this.pRepo.findAll();
	}
	
	public Product getOneProduct(Long id) {
		Product product = this.pRepo.findById(id).orElse(null);
		return product;
	}
	
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	public List<Product> productsNotContain(Category category) {
		return this.pRepo.findByCategoriesNotContaining(category);
	}
	
	public void addCategory(Product product, Category category) {
		List<Category> pAddedCategories = product.getCategories();
		pAddedCategories.add(category);
		product.setCategories(pAddedCategories);
		this.pRepo.save(product);
	}
}
