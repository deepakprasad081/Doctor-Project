package com.deepak.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepak.model.Patient;
import com.deepak.repository.PatientRepo;
import com.deepak.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientRepo patientRepo;
	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		Patient pat= patientRepo.save(patient);
		return pat;
	}

	@Override
	public String removePatient(int id) {
		// TODO Auto-generated method stub
		patientRepo.deleteById(id);
		return "data deleted successfully";
	}

	@Override
	public Optional<Patient> findPatientById(int id) {
		// TODO Auto-generated method stub
		Optional<Patient> pat=patientRepo.findById(id);
		if(pat.isPresent()) {
			return pat;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		List<Patient> patList=patientRepo.findAll();
		return patList;
	}

	@Override
	public String updatePatient(int id, Patient patient) {
		// TODO Auto-generated method stub
		Patient pat=patientRepo.getById(id);
		if(pat != null) {
		pat.setAge(patient.getAge());
		pat.setName(patient.getName());
		pat.setMedicalHistory(patient.getMedicalHistory());
		System.out.println("---------"+pat.getName());
		patientRepo.save(pat);
		
		
		
		
		return "updated successfully";
		
		}
		else {
			return "not found";
		}
	
	}
	
}
