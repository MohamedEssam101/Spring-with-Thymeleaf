package com.luv2code.springboot.thymeleafdemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service

// what i am doing here is delegating the calls from the service to the employeeDAO
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	// constructor injection
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theemployeeRepository) {
		employeeRepository = theemployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findByid(int theId) {
			//opetinal check if value presents 
		
		Optional<Employee> result = employeeRepository.findById(theId);
			//then i make an object from class employee
		Employee theEmployee = null;
			//then i see if result have value -> that i got from database
			//if there is a result and NOT empty ... 
			//get me the result and assigent it to theEmployee object
			// then i return the employee
		if(result.isPresent()) {
		theEmployee =  result.get();
		}
		else {
			//we didn't find any employee with the given ID
			throw new RuntimeException("Didn't Find Employee With the Given ID = " + theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);

	}

}
