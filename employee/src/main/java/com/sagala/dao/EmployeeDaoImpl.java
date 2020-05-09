package com.sagala.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sagala.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query =entityManager.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findById(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	public void save(Employee employee) {
		entityManager.persist(employee);
	}

	@Override
	public void deleteById(int employeeId) {
		Query query =entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", employeeId);
		query.executeUpdate();	
	}

	@Override
	public void update(Employee employee) {
		Employee dbEmployee =entityManager.merge(employee);
		employee.setId(dbEmployee.getId());
	}

}
