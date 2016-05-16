package com.leoman.doctor.service;

import com.leoman.common.service.GenericManager;
import com.leoman.doctor.entity.Doctor;
import org.springframework.data.domain.Page;

public interface IDoctorManager extends GenericManager<Doctor> {
	public Doctor findById(String id) throws Exception ;
	
	public Page<Doctor> findAll(Doctor doctor, Integer currentPage, Integer pageSize) throws Exception ;
}
