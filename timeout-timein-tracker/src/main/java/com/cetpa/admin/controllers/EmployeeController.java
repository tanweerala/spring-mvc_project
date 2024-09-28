package com.cetpa.admin.controllers;

import java.util.*;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.entities.Employee;
import com.cetpa.admin.services.EmployeeService;

@Controller
@RequestMapping("admin/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService; 
	
	@RequestMapping("dashboard")
	public String getEmployeeDashboard(Model model,HttpSession ses)
	{
		if(ses.getAttribute("id")==null)
		{
			return "redirect:admin/login";
		}
		List<Employee> employeeList=employeeService.getList();
		model.addAttribute("elist",employeeList);
		return "admin/employee/employee-dashboard";
	}
	@RequestMapping("add")
	public String getEmployeeAddView(HttpSession ses)
	{
		if(ses.getAttribute("id")==null)
		{
			return "redirect:admin/login";
		}
		return "admin/employee/add-employee";
	}
	@RequestMapping("save-record")
	public String saveEmployeeRecord(Employee employee)
	{
		employeeService.saveRecord(employee);
		return "redirect:dashboard";
	}
	@RequestMapping("delete-record")
	public String deleteEmployeeRecord(int eid)
	{
		employeeService.deleteRecord(eid);
		return "redirect:dashboard";
	}
	@RequestMapping("edit-record")
	public String getEmployeeEditView(int eid,Model model)
	{
		List<String> list=Arrays.asList("Training","Marketing","Accounts","Inventory","Sales","Human Resource");
		Employee employee=employeeService.getRecord(eid);
		model.addAttribute("emp",employee);
		model.addAttribute("dlist",list);
		return "admin/employee/edit-employee";
	}
	@RequestMapping("update-record")
	public String updateEmployeeRecord(Employee employee)
	{
		employeeService.updateRecord(employee);
		return "redirect:dashboard";
	}
	@RequestMapping("logout")
	public String adminLogout(HttpSession ses)
	{
		ses.invalidate();
		return "redirect:login";
	}
}
