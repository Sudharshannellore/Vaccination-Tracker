package com.citizenservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizenservice.entity.Citizen;
import com.citizenservice.repo.CitizenRepository;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	@Autowired
	private CitizenRepository repository;
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("WelCome Citizen Service", HttpStatus.OK ) ;
	}

	@PostMapping("/save")
	public ResponseEntity<String> getcitizens(@RequestBody Citizen citizen) {
		
	Citizen citizen2 =	repository.save(citizen);
      
	String status = null;
	
	if(citizen2 != null) {
		status = "Citizen Details SuccesfullyProcessed";
	}
	else {
		status = "Citizen Details Not Processed";

	}
	 return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<Citizen>> getcitizens(@PathVariable int id) {
		
		List<Citizen>citizens = repository.findByVaccinationCenterId(id);
		
		return new ResponseEntity<>(citizens, HttpStatus.OK);
		
	}
}
