package com.text.welcometoorchard.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.text.welcometoorchard.hospital.entity.Patient;

@Repository

public interface PatientRepository extends JpaRepository<Patient,Integer> {

}