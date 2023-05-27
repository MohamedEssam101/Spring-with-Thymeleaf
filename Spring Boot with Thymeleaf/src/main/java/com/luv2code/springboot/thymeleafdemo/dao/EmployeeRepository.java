package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
													  //Entity type Primary Key
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//thats it ..
	// no need to write any methods
	
	//add a method to sort by last name
	
	public List<Employee> findAllByOrderByLastNameAsc();
}
