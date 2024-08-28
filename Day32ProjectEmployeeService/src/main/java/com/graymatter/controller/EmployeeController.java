package com.graymatter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.graymatter.dto.DepartmentDto;
import com.graymatter.dto.EmployeeDepartment;
import com.graymatter.dto.EmployeeDto;
import com.graymatter.entity.Employee;
import com.graymatter.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/employee")
	public ResponseEntity<?> getAllEmployees() {
		return service.getAllEmployees();
	}
	
	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee (@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
    	return service.updateEmployee(employee);
    }
    
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
    	service.deleteEmployee(id);
    }
    
    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") int id) {
    	return service.getEmployeeById(id);
    }
    
    @GetMapping("/employee/deptId/{id}")
    public EmployeeDepartment getAllEmployeesOfDepartment(@PathVariable ("id") int id) {
    
    	String url = "http://DEPARTMENT-SERVICE/dept/" + id;
    	DepartmentDto deptDto = restTemplate.getForObject(url, DepartmentDto.class);
    	EmployeeDto empDto = new EmployeeDto(1, "Divyanshu", 70000, id);
    	return new EmployeeDepartment(empDto, deptDto);
    	
    }
    
    @GetMapping("/employee/{deptId}")
    public List<Employee> getEmployeeByDeptId(@PathVariable ("deptId") int deptId) {
    	return service.getEmployeeByDeptId(deptId);
    }
	
	
}
