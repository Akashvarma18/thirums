package com.zettamine.mapper;

import com.zettamine.dto.EmployeeDTO;
import com.zettamine.entity.Employee;

public class EmployeeMapper {

	public static Employee dtoToEntity(EmployeeDTO dto) {
		
		return new Employee(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
			
	}
	
	public static EmployeeDTO entitytoDto(Employee entity) {
		
		return new EmployeeDTO(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getEmail());
		
	}
	
	
	
}
