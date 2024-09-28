package com.cetpa.admin.repositories;

import java.util.List;

import com.cetpa.admin.entities.Employee;
import com.cetpa.admin.entities.TimeInfo;

public interface EmployeeRepository 
{
	List<Employee> getList(String status);
	void saveEmployee(Employee employee);
	Employee getEmployee(int eid);
	void deleteEmployee(Employee employee);
	void updateEmployee(Employee empold, Employee empnew);
	List<Employee> getList();
	List<Employee> getEmployeeList(String status);
	void updateEmployeeStatus(String status,int eid);
}