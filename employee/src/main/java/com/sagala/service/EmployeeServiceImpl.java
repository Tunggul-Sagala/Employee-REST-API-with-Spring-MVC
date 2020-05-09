package com.sagala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagala.dao.EmployeeDao;
import com.sagala.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public List<Employee> findAll() {
		List<Employee> employees =employeeDao.findAll();
		return employees;
	}

	@Override
	@Transactional
	public Employee findById(int employeeId) {
		return employeeDao.findById(employeeId);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int employeeId) {
		employeeDao.deleteById(employeeId);
	}

	@Override
	@Transactional
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

}
