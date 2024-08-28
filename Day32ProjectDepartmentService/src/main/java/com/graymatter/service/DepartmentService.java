package com.graymatter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.entity.Department;
import com.graymatter.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository repository;

	 public Department getDepartmentById(int id) {
		 return repository.findById(id);
	 }


	
	public Department addDepartment(Department department) {
        return repository.save(department);
    }
}
