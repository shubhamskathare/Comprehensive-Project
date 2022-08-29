package com.text.welcometoorchard.hospital.controller;

import java.util.List;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.text.welcometoorchard.hospital.entity.Doctor;
import com.text.welcometoorchard.hospital.service.HospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

    @Autowired
    HospitalService service;
    
    //to post doctor-info
    @PostMapping("/doctors/doctor")
    public boolean addUser(@RequestBody Doctor doctor) {
        service.saveDoctorInformation(doctor);
        return true;

    }
     
   //to get doctor-info
    @GetMapping("doctors/doctor/{name}")
    public MappingJacksonValue getDoctorInformation(@PathVariable String name) {
        Doctor doctor = service.showDoctorInformation(name);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "field","patient_count");

        FilterProvider filters = new SimpleFilterProvider().addFilter("DoctorFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(doctor);

        mapping.setFilters(filters);

        return mapping;
    }
     
   //to get doctor-info w.r.t name
    @GetMapping("doctors/doc/{name}")
    public Doctor getDoctorInfo(@PathVariable String name) {
        Doctor doctor = service.showDoctorInformation(name);
        return doctor;
    }
    
   //to get list of doctors
    @GetMapping("doctors")
    public MappingJacksonValue getListOfDoctor() {
        List<Doctor> doctors = service.getDoctors() ;
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");

        FilterProvider filters = new SimpleFilterProvider().addFilter("DoctorFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(doctors);

        mapping.setFilters(filters);

        return mapping;
    }
}
