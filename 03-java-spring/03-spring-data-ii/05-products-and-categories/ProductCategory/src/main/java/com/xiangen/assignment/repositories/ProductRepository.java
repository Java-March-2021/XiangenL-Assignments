package com.xiangen.assignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xiangen.assignment.models.Category;
import com.xiangen.assignment.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findByCategoriesNotContaining(Category category);
}

