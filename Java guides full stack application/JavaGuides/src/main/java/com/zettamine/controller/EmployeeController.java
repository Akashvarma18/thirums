package com.zettamine.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.dto.EmployeeDTO;
import com.zettamine.entity.Employee;
import com.zettamine.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
	
	EmployeeService employeeService;
	
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO dto){
		
		EmployeeDTO savedEmployee = employeeService.saveEmployee(dto);
		
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
				
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") Long id){
		
		EmployeeDTO getEmployee = employeeService.getEmployee(id);
		
		return new ResponseEntity<>(getEmployee, HttpStatus.OK);
			
	}
	
	@GetMapping("getall")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		
		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		
		return new ResponseEntity<>(employees, HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployees(@PathVariable("id") Long id, @RequestBody EmployeeDTO dto){
		
		EmployeeDTO updateEmp = employeeService.updateEmployee(id, dto);
		
		return new ResponseEntity<>(updateEmp, HttpStatus.OK);		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
		
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<>("Employee Successfully deleted", HttpStatus.OK);
		
		
		
	}
	
	

}
