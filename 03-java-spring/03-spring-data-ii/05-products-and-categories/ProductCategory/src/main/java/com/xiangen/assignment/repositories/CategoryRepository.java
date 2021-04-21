package com.xiangen.assignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xiangen.assignment.models.Category;
import com.xiangen.assignment.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	
	List<Category> findByProductsNotContaining(Product product);
}
