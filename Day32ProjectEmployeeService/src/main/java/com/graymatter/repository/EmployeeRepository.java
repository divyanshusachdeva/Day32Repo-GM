package com.graymatter.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graymatter.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByDeptId(int deptId);

	//void deleteById(long id);
	//Optional<Employee> findById(long id);

}