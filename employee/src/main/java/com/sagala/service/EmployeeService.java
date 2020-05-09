package com.sagala.service;

import java.util.List;

import com.sagala.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();

	public Employee findById(int employeeId);

	public void save(Employee employee);

	public void deleteById(int employeeId);

	public void update(Employee employee);

}
