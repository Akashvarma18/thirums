package com.zettamine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zettamine.entity.Department;
import com.zettamine.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
			
	}
	
	public Department getDepartmentById(Long id) {
		return departmentRepository.findById(id).get();
	}
	
	
	
	
	
	

}
