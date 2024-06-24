package com.zettamine.service;

import java.util.List;

import com.zettamine.dto.EmployeeDTO;
import com.zettamine.entity.Employee;

public interface EmployeeService {
	
	 public EmployeeDTO saveEmployee(EmployeeDTO dto);
	 public EmployeeDTO getEmployee(Long id);
	 public List<EmployeeDTO> getAllEmployees();
	 public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto);
	 public void deleteEmployee(Long id);
	 

}
