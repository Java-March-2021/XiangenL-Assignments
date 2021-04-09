package com.xiangen.assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangen.assignment.models.License;
import com.xiangen.assignment.models.Person;
import com.xiangen.assignment.repositories.LicenseRepository;
import com.xiangen.assignment.repositories.PersonRepository;

@Service
public class DMVService {
	@Autowired
	private LicenseRepository lRepo;
	private PersonRepository pRepo;
	
	public DMVService(LicenseRepository licRepo, PersonRepository perRepo) {
		this.lRepo = licRepo;
		this.pRepo= perRepo;
	}
	
	// get one license
	public License getOneLicense(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	// create license
	// generate license number
	public int generateLicenseNumber() {
		License lic = this.lRepo.findTopByOrderByNumberDesc();
		if(lic == null) {
			return 1;
		}
		int largestNumber = lic.getNumber();
		largestNumber++;
		return (largestNumber);
			
	}
	
	public License createLicense(License newLicense) {
		newLicense.setNumber(this.generateLicenseNumber());
		return this.lRepo.save(newLicense);
	}
	
	// get all persons
	public List<Person> getAllPersons() {
		return this.pRepo.findAll();
	}
	
	// get unLicensedPeople
	public List<Person> getUnlicensedPeople(){
		return this.pRepo.findByLicenseIdIsNull();
	}
	
	// get one person
	public Person getOnePerson(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	// create new person
	public Person createPerson(Person newPerson) {
		return this.pRepo.save(newPerson);
	}
	
	// delete
	public void deletePerson(Long id) {
		this.pRepo.deleteById(id);
	}
}
