package com.zettamine.exception;

public class StudentNotfoundException extends RuntimeException {
	
	private final Long studentId;
	
	public StudentNotfoundException(Long studentId) {
		
		 super("Student with ID " + studentId + " not found");
	     this.studentId = studentId;
		
	}
	
	public Long getStudentId() {
		return studentId;
	}
	
	

}
