package com.sagala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagala.entity.Employee;
import com.sagala.exception.EmployeeNotFoundException;
import com.sagala.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> employees() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable("employeeId") int employeeId) {
		Employee employee =employeeService.findById(employeeId);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee not found, Id: " + employeeId);
		}
		else {
			return employee;
		}
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee) {
		employeeService.update(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteById(@PathVariable("employeeId") int employeeId) {
		employeeService.deleteById(employeeId);
		return "Employee deleted with id: " + employeeId;
	}
}
