package com.qa.thain.alex.springboot.database.app.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.qa.thain.alex.springboot.database.app.application.exception.ResourceNotFoundException;
import com.qa.thain.alex.springboot.database.app.application.model.*;
import com.qa.thain.alex.springboot.database.app.application.repository.personRepository;

@RestController
@RequestMapping("/api")
public class MySpringBootDataAppController {

	@Autowired
	personRepository myRepository;

	//method to create a person
	@PostMapping("/person")
	public MySpringBootDatabaseModel createPerson(@Valid @RequestBody MySpringBootDatabaseModel mSDM) {
		return myRepository.save(mSDM);		
	}
	
	//Method to get a person
	@GetMapping("/person/{id}")
	public MySpringBootDatabaseModel getPersonbyID(@PathVariable(value="id")Long personID) {
		return myRepository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("MySpringBootDatabaseModel", "id",personID));
	}
	
	//Method to get all people
	@GetMapping("/person")
	public List<MySpringBootDatabaseModel> getAllPeople() {
		return myRepository.findAll();
	}
	
	//Method to update a person
	@PutMapping("/person/{id}")
	public MySpringBootDatabaseModel updatePerson(@PathVariable(value = "id") Long personID,
			@Valid @RequestBody MySpringBootDatabaseModel personDetails){
		
		MySpringBootDatabaseModel mSDM = myRepository.findById(personID).orElseThrow(() -> new ResourceNotFoundException("Person","id", personID));
		
		mSDM.setName(personDetails.getName());
		mSDM.setAddress(personDetails.getAddress());
		mSDM.setAge(personDetails.getAge());
		
		MySpringBootDatabaseModel updateData = myRepository.save(mSDM);
		return updateData;
	}
	
	//Method to remove a person
	@DeleteMapping("/person/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value="id")Long personID) {
		MySpringBootDatabaseModel mSDM = myRepository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("Person","id",personID));
		
		myRepository.delete(mSDM);
		return ResponseEntity.ok().build();
	
	}	
}
