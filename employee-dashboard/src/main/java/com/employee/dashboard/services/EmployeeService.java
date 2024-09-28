package com.employee.dashboard.services;

import java.util.List;

import com.employee.dashboard.entities.Employee;

public interface EmployeeService 
{
	List<Employee> getList();
	void saveEmployee(Employee employee);
	void deleteEmployee(int eid);
}
