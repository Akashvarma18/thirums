package com.zettamine.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.zettamine.Repository.EmployeeRepository;
import com.zettamine.dto.EmployeeDTO;
import com.zettamine.entity.Employee;
import com.zettamine.exception.ResourceNotFoundException;
import com.zettamine.mapper.EmployeeMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepository empRepo;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO dto) {
		
		Employee emp = EmployeeMapper.dtoToEntity(dto);
		Employee savedEmployee = empRepo.save(emp);
		
		return EmployeeMapper.entitytoDto(savedEmployee);
		
		
	}

	@Override
	public EmployeeDTO getEmployee(Long id) {
		
		Employee emp = empRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exists with give id" + id));	
		return EmployeeMapper.entitytoDto(emp);
	
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		
		List<Employee> employees = empRepo.findAll();
		 List<EmployeeDTO> employeesDto = employees.stream().map(e->EmployeeMapper.entitytoDto(e)).collect(Collectors.toList());
		 return employeesDto;
		
	}

	@Override
	public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
		
		Employee emp = empRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exists with a id no : " + id));
		
		emp.setFirstName(dto.getFirstName());
		emp.setLastName(dto.getLastName());
		emp.setEmail(dto.getEmail());
		
		empRepo.save(emp);
		
		return EmployeeMapper.entitytoDto(emp);
		    
	}

	@Override
	public void deleteEmployee(Long id) {
		
		Employee emp = empRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with id: " + id));
		empRepo.deleteById(id);
				
	}
	
	
	
	
	

}
