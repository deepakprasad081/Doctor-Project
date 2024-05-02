package com.deepak.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.model.Patient;
import com.deepak.serviceImpl.PatientServiceImpl;

@RestController
@RequestMapping("/pat")
public class PatientController {
	
	
	@Autowired
	private PatientServiceImpl patService;
	
	@PostMapping("/addPatient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
		
		Patient pat= patService.addPatient(patient);
		
		return new ResponseEntity<Patient>(pat,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/removePatient/{id}")
	public ResponseEntity<String> removePatient(@PathVariable int id){
		patService.removePatient(id);
		return new ResponseEntity<String>("removed successfully", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findPatient/{id}")
	public ResponseEntity<Optional<Patient>> findPatById(@PathVariable int id){
		
		Optional<Patient> pat=patService.findPatientById(id);
		return new ResponseEntity<Optional<Patient>>(pat,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allPatient")
	public ResponseEntity<List<Patient>> listOfPatient(){
		
		List<Patient>  pat=patService.getAllPatient();
		return new ResponseEntity<List<Patient>>(pat,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updatePatient/{id}")
	public ResponseEntity<String> updatePatient(@RequestBody Patient patient, @PathVariable int id){
		
		patService.updatePatient(id,patient);
		
		return new ResponseEntity<String>("updated successfully",HttpStatus.ACCEPTED);
		
		
	}

}
