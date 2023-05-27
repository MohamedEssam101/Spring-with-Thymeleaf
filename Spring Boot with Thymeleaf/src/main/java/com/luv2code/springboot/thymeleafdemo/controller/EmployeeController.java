package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.Service.EmployeeService;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		
		employeeService = theEmployeeService;
	}
	
	//add mapping for "/list"
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		//get employees from database
		List<Employee> theEmployees = employeeService.findAll();
		//add the spring model
		theModel.addAttribute("employees",theEmployees);
		
		return "employees/list-employees";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create the model attribute to bind the form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate") 
	public String showFormForUpdate(@RequestParam("employeeId") int theId ,
								Model theModel) {
		
		//get the employee from the Database
		Employee theEmployee = employeeService.findByid(theId);
		
		//set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		
		//send over to our  form 
		return "employees/employee-form";
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		//save the Employee
		employeeService.save(theEmployee);
		
		//use a redirect to prevent duplicate submission
		return "redirect:/employees/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId
			) {
		
		//delete the employee
		employeeService.deleteById(theId);
		
		//redirect to /employee/list
		return "redirect:/employees/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}