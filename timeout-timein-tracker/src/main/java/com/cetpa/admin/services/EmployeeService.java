package com.cetpa.admin.services;

import java.util.List;

import com.cetpa.admin.entities.Employee;

public interface EmployeeService 
{
	List<Employee> getList();
	void saveRecord(Employee employee);
	void deleteRecord(int eid);
	Employee getRecord(int eid);
	void updateRecord(Employee employee);
	List<Employee> getList(String status);
}
