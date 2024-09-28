package com.employee.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.dashboard.entities.Employee;
import com.employee.dashboard.services.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("dashboard")
	public String getDashboard(Model model)
	{
		List<Employee> employeeList=employeeService.getList();
		model.addAttribute("elist",employeeList);
		return "employee-dashboard";
	}
	@RequestMapping("add")
	public String getAddView()
	{
		return "add-employee";
	}
	@RequestMapping("save-record")
	public String saveRecord(Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:/dashboard";
	}
	@RequestMapping("delete-record")
	public String deleteRecord(int eid)
	{
		employeeService.deleteEmployee(eid);
		return "redirect:/dashboard";
	}
}
