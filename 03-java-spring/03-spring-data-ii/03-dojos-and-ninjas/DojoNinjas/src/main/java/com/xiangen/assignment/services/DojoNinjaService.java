package com.xiangen.assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangen.assignment.models.Dojo;
import com.xiangen.assignment.models.Ninja;
import com.xiangen.assignment.repositories.DojoRepository;
import com.xiangen.assignment.repositories.NinjaRepository;

@Service
public class DojoNinjaService {
	@Autowired
	private DojoRepository dRepo;
	@Autowired
	private NinjaRepository nRepo;
	
	// get all dojos
	public List<Dojo> getAllDojo(){
		return this.dRepo.findAll();
	}
	
	// get one dojo
	public Dojo getOneDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	// create dojo
	public Dojo createDojo(Dojo newDojo) {
		return this.dRepo.save(newDojo);
	}
	
	// get all ninjas
	public List<Ninja> getAllNinja(){
		return this.nRepo.findAll();
	}

	// create ninja
	public Ninja createNinja(Ninja newNinja) {
		return this.nRepo.save(newNinja);
	}
	
	// delete dojo
	public void delete(Long id) {
		this.dRepo.deleteById(id);
	}
}
