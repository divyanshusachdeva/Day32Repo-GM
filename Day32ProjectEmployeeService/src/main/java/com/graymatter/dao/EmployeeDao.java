package com.graymatter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.graymatter.entity.Employee;
import com.graymatter.repository.EmployeeRepository;

@Component
public class EmployeeDao {

	@Autowired
	EmployeeRepository repository;

	public ResponseEntity<?>addEmployee(Employee employee){
    	Map<String,Object> map = new HashMap<String, Object>();
    	Employee p = repository.save(employee);
    	if(p!=null) {
    		map.put("status",11);
    		map.put("data",p);
    		return new ResponseEntity<>(map,HttpStatus.CREATED);
    	}
    	else {
    		map.put("status",20);
    		map.put("data","Not Saved");
    		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    	}

    }
    
    public Employee updateEmployee(Employee employee) {
    	return repository.save(employee); 

    }
    
    public ResponseEntity<?>getAllEmployees(){
    	List<Employee> pList = repository.findAll();
    	Map<String,Object> map = new HashMap<String,Object>();
    	if(!pList.isEmpty()) {
    		map.put("status",10);
    		map.put("data",pList);
    		return new ResponseEntity<>(map,HttpStatus.OK);
    	}
    	else {
    		map.put("status",20);
    		map.put("data","List is empty");
    		return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
    	}
    }

    public void deleteEmployee(int id) {
    	repository.deleteById(id);
    }
    
    public Optional<Employee> getEmployeeById(int id) {
    	Optional<Employee> employee = repository.findById(id);
    	return employee;
    }

	public List<Employee> getEmployeeByDeptId(int deptId) {
		return repository.findByDeptId(deptId);
	}

	
}
