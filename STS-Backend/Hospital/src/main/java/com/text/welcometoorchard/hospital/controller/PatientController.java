package com.text.welcometoorchard.hospital.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.text.welcometoorchard.hospital.entity.Patient;
import com.text.welcometoorchard.hospital.exception.PatientNotFoundException;
import com.text.welcometoorchard.hospital.service.HospitalService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    @Autowired
    HospitalService service;
    
    //to get patient-info
    @GetMapping("/patients/patient/{id}")
    public Patient showPatientInformation(@PathVariable Integer id){
        Patient patient = service.showPatientInformation(id);
        if(patient == null){
            throw new PatientNotFoundException(id + " is not in database");
        }
        return patient;
    }
    
   //to post patient
    @PostMapping("patients/patient")
    public boolean createPatient(@RequestBody Patient patient){
        service.savePatientInformation(patient);
        return true;
    }

}