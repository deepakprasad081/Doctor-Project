package com.deepak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{

}
