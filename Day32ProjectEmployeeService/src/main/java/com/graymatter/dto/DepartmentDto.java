package com.graymatter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DepartmentDto {

	private int deptId;
	private String deptName;
	private String deptLoc;
	
}
