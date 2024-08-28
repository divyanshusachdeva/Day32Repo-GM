package com.graymatter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.graymatter.dao.EmployeeDao;
import com.graymatter.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
		
    public ResponseEntity<?> getAllEmployees() {
        return dao.getAllEmployees();
    }
 
    public ResponseEntity<?> addEmployee(Employee employee) {
        return dao.addEmployee(employee);
    }

    public void deleteEmployee(int id) {
        dao.deleteEmployee(id);
    }

    public Employee updateEmployee(Employee employee) {
        return dao.updateEmployee(employee);
    }

	public Optional<Employee> getEmployeeById(int id) {
		return dao.getEmployeeById(id);
	}

	public List<Employee> getEmployeeByDeptId(int deptId) {
		return dao.getEmployeeByDeptId(deptId);
	}


}

