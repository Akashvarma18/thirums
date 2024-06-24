package com.zettamine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.entity.Student;
import com.zettamine.service.StudentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);	
	}
	
	@GetMapping("/{id}")
	@CircuitBreaker(name="cb", fallbackMethod = "fallbackMethod")
	@Retry(name="cb",fallbackMethod = "fallbackMethod")
	public ResponseEntity<String> getStudentWithDepartment(@PathVariable Long id){
	    String result = studentService.getStudentWithDepartment(id);    
	    return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
	// Fallback method for CircuitBreaker
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> fallbackMethod(Long id, Throwable throwable) {
		String fallbackResponse = "Fallback response: Student service is currently unavailable. Please try again later.";
		return new ResponseEntity<>(fallbackResponse, HttpStatus.BAD_REQUEST);
	}
}
