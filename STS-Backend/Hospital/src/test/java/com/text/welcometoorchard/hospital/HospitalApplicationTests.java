package com.text.welcometoorchard.hospital;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.text.welcometoorchard.hospital.repository.DoctorRepository;
import com.text.welcometoorchard.hospital.repository.PatientRepository;

@SpringBootTest
class HospitalApplicationTests {
	
	@Autowired
	DoctorRepository doctRepo;
	
	@Autowired
	PatientRepository patRepo;
	

	@Test
	void findByPatientId() {
		assertNotNull(patRepo.findById(2).get());
		
    }
	
	@Test
	void findByDoctorId() {
		assertNotNull(doctRepo.findById(1).get());
	}

}
