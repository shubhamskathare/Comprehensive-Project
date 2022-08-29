package com.text.welcometoorchard.hospital.service;

import java.util.List;

import com.text.welcometoorchard.hospital.entity.Doctor;
import com.text.welcometoorchard.hospital.entity.Patient;



public interface HospitalService {

    public Doctor showDoctorInformation(String name);
    public Patient showPatientInformation(Integer Id);
    public boolean saveDoctorInformation(Doctor doctor);
    public boolean savePatientInformation(Patient patient);
    public List<Patient> getPatientListOfDoctor(String name,Doctor doctor);
    public List<Doctor> getDoctors();

}
