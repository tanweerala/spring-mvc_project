package com.employee.dashboard.repositories;

import java.util.List;

import com.employee.dashboard.entities.Employee;

public interface EmployeeRepository 
{
	List<Employee> getEmployeeList();
	void saveRecord(Employee employee);
	Employee getEmployee(int eid);
	void deleteRecord(Employee employee);
}
