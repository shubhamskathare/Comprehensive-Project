package com.text.welcometoorchard.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.text.welcometoorchard.hospital.entity.Doctor;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface DoctorRepository  extends JpaRepository<Doctor,Integer> {
    public Doctor findByName(String name);
}
