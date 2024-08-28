package com.graymatter.entity;

import java.util.ArrayList;
import java.util.List;

import com.graymatter.dto.EmployeeDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Department {

	@Id
	private int deptId;
	private String deptName;
	private String deptLoc;

	@Transient
	List<EmployeeDto> empList = new ArrayList<EmployeeDto>();

}
