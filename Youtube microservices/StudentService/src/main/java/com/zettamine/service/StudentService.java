package com.zettamine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zettamine.entity.Department;
import com.zettamine.entity.Student;
import com.zettamine.exception.StudentNotfoundException;
import com.zettamine.repository.StudentRepository;

@Service
public class StudentService {
	
	private String baseurl = "http://localhost:8080/department/";
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
		
	}
	
	public String getStudentWithDepartment(Long id) {
		
		Student student = studentRepository.findById(id)
				   .orElseThrow(() -> new StudentNotfoundException(id));
		Department department = restTemplate.getForObject(baseurl+student.getDepartmentId(), Department.class);
	
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n");
		buffer.append(student.getStudentId()+"  "+student.getFirstName()+ "  "+student.getLastName()+"  "+student.getEmail()+"  "+student.getDepartmentId());
		buffer.append("\n");
		buffer.append(department.getDepartmentName()+"  "+department.getDepartmentCode()+"  "+department.getDepartmentAddress());
		return buffer.toString();
		
		
		
	}
	
	
	
	
	
	

}
