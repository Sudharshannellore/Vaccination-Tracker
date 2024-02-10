package com.vaccinationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.vaccinationservice.entity.Vaccination;
import com.vaccinationservice.model.Citizen;
import com.vaccinationservice.model.RequiredResponse;
import com.vaccinationservice.repo.VaccinationRepo;

@Controller
@RequestMapping("/vaccinationservice")
public class VaccinationController {
	
	@Autowired
	private VaccinationRepo repo;
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("WelcomeToVaccinationService",HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> add(@RequestBody Vaccination vaccination){
	Vaccination vaccination2 = repo.save(vaccination);
	String status = null;
	
	if (vaccination2!=null) {
		status = "VaccinationDetailsSuccessfullyStored";
	}
	else {
     	status = "VaccinationDetailsNotStored";
	}
	
	return new ResponseEntity<>(status,HttpStatus.OK);
	}
    
	@GetMapping("/get/{id}")
	public ResponseEntity<RequiredResponse> response(@PathVariable int id) {
		
		RequiredResponse response = new RequiredResponse();
		
	    Vaccination vaccination = repo.findById(id).get();
	
      	response.setVaccination(vaccination);
		
      	List<Citizen>citizens = template.getForObject("http://CITIZENSERVICE/citizen/get/"+id, List.class);
      	
      	response.setCitizens(citizens);
      	
      	return new ResponseEntity<RequiredResponse>(response,HttpStatus.OK);
      	
	}
}
