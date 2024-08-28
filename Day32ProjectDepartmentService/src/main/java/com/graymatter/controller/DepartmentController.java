package com.graymatter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.graymatter.dto.EmployeeDto;
import com.graymatter.entity.Department;
import com.graymatter.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/department")
	public List<Department> getAllDepartments() {
		return null;
	}
	
	@PostMapping("/dept")
	public Department addDepartment(@RequestBody Department department) {
		return service.addDepartment(department);
	}

    @GetMapping("/department/{id}")
    public Department getEmployeeById(@PathVariable("id") int id) {
    	return service.getDepartmentById(id);
    }
    	
	@GetMapping("/emp/dept/{id}")
	public Department getAllEmployeesOfDepartment(@PathVariable("id") int id) {
		
		//findById on department
		Department dept = service.getDepartmentById(id);
		
		//find all employees under the same department using employee microservice findByDeptId endpoint
		String url = "http://EMPLOYEE-SERVICE/employee/" + id;
		ArrayList<EmployeeDto> empList = restTemplate.getForObject(url, ArrayList.class);
		
		//set employees into the dept object
		dept.setEmpList(empList);
		return dept;
		
	}

	

}
