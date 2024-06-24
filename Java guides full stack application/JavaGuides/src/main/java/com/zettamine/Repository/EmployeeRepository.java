package com.zettamine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
