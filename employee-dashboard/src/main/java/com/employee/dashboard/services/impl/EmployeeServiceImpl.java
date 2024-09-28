package com.employee.dashboard.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dashboard.entities.Employee;
import com.employee.dashboard.repositories.EmployeeRepository;
import com.employee.dashboard.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getList() 
	{
		return employeeRepository.getEmployeeList();
	}
	public void saveEmployee(Employee employee) 
	{
		employeeRepository.saveRecord(employee);
	}
	public void deleteEmployee(int eid) 
	{
		Employee employee=employeeRepository.getEmployee(eid);
		employeeRepository.deleteRecord(employee);
	}
}
