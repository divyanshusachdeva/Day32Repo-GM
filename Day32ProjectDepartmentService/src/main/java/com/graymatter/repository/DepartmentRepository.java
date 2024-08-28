package com.graymatter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graymatter.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	Department findById(int id);
	
}
