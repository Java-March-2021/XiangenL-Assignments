package com.xiangen.assignment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xiangen.assignment.models.Language;
import com.xiangen.assignment.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository bRepo;
	public LanguageService(LanguageRepository repo) {
		this.bRepo = repo;
	}
	
	// get all
	public List<Language> getAll(){
		return this.bRepo.findAll();
	}
	
	// get one
	public Language getOne(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
	
	// create
	public Language create(Language newLan) {
		return this.bRepo.save(newLan);
	}
	
	//update
	public Language update(Language updatedLan) {
		return this.bRepo.save(updatedLan);
	}
	
	// delete
	public void delete(Long id) {
		this.bRepo.deleteById(id);
	}
	
}
