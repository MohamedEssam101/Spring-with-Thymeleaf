package com.luv2code.springboot.thymeleafdemo.Service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findByid(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);
}
