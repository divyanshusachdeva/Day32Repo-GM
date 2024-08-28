package com.graymatter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class EmployeeDto {

	private int empId;
	private String empName;
	private double empSal;
	private int deptId;
}
