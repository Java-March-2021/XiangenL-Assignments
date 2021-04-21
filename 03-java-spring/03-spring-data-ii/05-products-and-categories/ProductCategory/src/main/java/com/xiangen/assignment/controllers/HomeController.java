package com.xiangen.assignment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiangen.assignment.models.Category;
import com.xiangen.assignment.models.Product;
import com.xiangen.assignment.services.CategoryService;
import com.xiangen.assignment.services.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService pService;
	@Autowired
	private CategoryService cService;
	
	// index
	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("products", this.pService.allProducts());
		model.addAttribute("categories", this.cService.allCategories());
		return "index.jsp";
	}
	
	// add product
	@GetMapping("/products/new")
	public String addProducts(@ModelAttribute("product") Product product, Model pModel){
		pModel.addAttribute("product", product);
		return "addProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProducts(@Valid @ModelAttribute("product") Product product, BindingResult result, Model pModel){
		if(result.hasErrors()) {
			pModel.addAttribute("product", product);
			return "addProduct.jsp";
		}
		this.pService.createProduct(product);
		return "redirect:/";
	}
	
	// add category
	@GetMapping("/categories/new")
	public String addCategories(@ModelAttribute("category") Category category, Model model){
		model.addAttribute("category", category);
		return "addCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String newCategories(@Valid @ModelAttribute("category") Category category, BindingResult result){
		if(result.hasErrors()) {
			return "addCategory.jsp";
		}
		this.cService.createCategory(category);
		return "redirect:/";
	}

	// show product
	@GetMapping("/products/{id}") 
	public String showProduct(@PathVariable("id") Long id, Model model, @ModelAttribute("category") Category category) {
		Product thisProduct = this.pService.getOneProduct(id);
		List<Category> categories = this.cService.categoryNotContain(thisProduct);
		model.addAttribute("product", thisProduct);
		model.addAttribute("categories", categories);
		return "product.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String selectCategory(@PathVariable("id") Long id, @Valid @ModelAttribute("category") Category category, BindingResult result, Model model, @RequestParam("categoryId") Long categoryId) {
		if(result.hasErrors()) {
			Product thisProduct = this.pService.getOneProduct(id);
			List<Category> categories = this.cService.categoryNotContain(thisProduct);
			model.addAttribute("product", thisProduct);
			model.addAttribute("categories", categories);
			return "product.jsp";
		}
		Product thisProduct = this.pService.getOneProduct(id);
		Category pAddedCategory = this.cService.getOneCategory(categoryId);	
		this.pService.addCategory(thisProduct, pAddedCategory);
		return "redirect:/products/{id}" ;
	}
	
	// show category
		@GetMapping("/categories/{id}") 
		public String showCategory(@PathVariable("id") Long id, Model model, @ModelAttribute("product") Product product) {
			Category category = this.cService.getOneCategory(id);
			List<Product> products = this.pService.productsNotContain(category);
			model.addAttribute("products", products);
			model.addAttribute("category", category);
			return "category.jsp";
		}
		
		@PostMapping("/categories/{id}")
		public String selectProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, @PathVariable("id") Long id, Model model, @RequestParam("productId") Long productId) {
			if(result.hasErrors()) {
				Category thisCategory = this.cService.getOneCategory(id);
				List<Product> products = this.pService.productsNotContain(thisCategory);
				model.addAttribute("products", products);
				model.addAttribute("category", thisCategory);
				return "category.jsp";
			}
			Category thisCategory = this.cService.getOneCategory(id);
			Product cAddedProduct = this.pService.getOneProduct(productId);
			this.pService.addCategory(cAddedProduct, thisCategory);
			return "redirect:/categories/{id}";
		}
}
