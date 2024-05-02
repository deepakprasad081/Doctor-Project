package com.deepak.service;

import java.util.List;
import java.util.Optional;

import com.deepak.model.Patient;

public interface PatientService {
	
	public Patient addPatient(Patient patient);
	
	public String removePatient(int id);
	
	public Optional<Patient> findPatientById(int id);
	
	public List<Patient> getAllPatient();
	
	public String updatePatient(int id, Patient patient);

}
