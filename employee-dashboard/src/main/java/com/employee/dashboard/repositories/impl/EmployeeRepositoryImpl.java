package com.employee.dashboard.repositories.impl;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.dashboard.entities.Employee;
import com.employee.dashboard.repositories.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository 
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public EmployeeRepositoryImpl(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}
	public List<Employee> getEmployeeList() 
	{
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		List<Employee> elist=query.list();
		return elist;
	}
	public void saveRecord(Employee employee) 
	{
		transaction.begin();
		session.persist(employee);
		transaction.commit();
	}
	public Employee getEmployee(int eid) 
	{
		Employee emp=session.load(Employee.class,eid);
		return emp;
	}
	public void deleteRecord(Employee employee) 
	{
		transaction.begin();
		session.delete(employee);
		transaction.commit();
	}
}
