package com.cetpa.admin.repositories.impl;

import java.util.*;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cetpa.admin.entities.Employee;
import com.cetpa.admin.repositories.EmployeeRepository;

@Repository
public class EmployeeRespositoryImpl implements EmployeeRepository 
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public EmployeeRespositoryImpl(SessionFactory sessionFactory)
	{
		session=sessionFactory.openSession();
		transaction=session.getTransaction(); 
	}
	public List<Employee> getList() 
	{
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		return query.list();
	}
	public void saveEmployee(Employee employee) 
	{
		transaction.begin();
		session.save(employee);
		transaction.commit();
	}
	public Employee getEmployee(int eid) 
	{
		Employee employee=session.get(Employee.class,eid);
		return employee;
	}
	public void deleteEmployee(Employee employee) 
	{
		transaction.begin();
		session.delete(employee);
		transaction.commit();
	}
	public void updateEmployee(Employee empold, Employee empnew) 
	{
		transaction.begin();
		empold.setFirstname(empnew.getFirstname());
		empold.setLastname(empnew.getLastname());
		empold.setPhone(empnew.getPhone());
		empold.setEmail(empnew.getEmail());
		empold.setDepartment(empnew.getDepartment());
		empold.setSalary(empnew.getSalary());
		transaction.commit();
	}
	public List<Employee> getEmployeeList(String status) 
	{
		Query<Employee> query=session.createQuery("from Employee where status=:arg",Employee.class);
		query.setParameter("arg",status);
		return query.list();
	}
	@Override
	public List<Employee> getList(String status) {
		// TODO Auto-generated method stub
		return null;
	}
	public void updateEmployeeStatus(String status,int eid) 
	{
		transaction.begin();
		Query query=session.createQuery("update Employee set status=:arg1 where eid=:arg2");
		query.setParameter("arg1",status);
		query.setParameter("arg2",eid);
		query.executeUpdate();
		transaction.commit();
	}
}
