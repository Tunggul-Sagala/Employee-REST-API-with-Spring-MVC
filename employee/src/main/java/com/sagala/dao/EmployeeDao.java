package com.sagala.dao;

import java.util.List;

import com.sagala.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> findAll();

	public Employee findById(int employeeId);

	public void save(Employee employee);

	public void deleteById(int employeeId);

	public void update(Employee employee);

}
