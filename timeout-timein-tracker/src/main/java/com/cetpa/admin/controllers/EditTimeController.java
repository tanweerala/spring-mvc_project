package com.cetpa.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.entities.Employee;
import com.cetpa.admin.services.EditTimeService;
import com.cetpa.admin.services.EmployeeService;

@Controller
@RequestMapping("admin/edittime")
public class EditTimeController 
{
	@Autowired private EmployeeService employeeService;
	@Autowired private EditTimeService editTimeService;
	
	@RequestMapping("listout")
	public String getEmployeeList1(Model model)
	{
		List<Employee> empList=employeeService.getList();
		model.addAttribute("elist",empList);
		return "admin/edittime/out/employee-list";
	}
	@RequestMapping("edit-outtime")
	public String editEmployeeOuttime(int weid,int reid)
	{
		editTimeService.updateOutTime(weid,reid);
		return "admin/edittime/out/out-updated";
	}
	@RequestMapping("listin")
	public String getEmployeeList2(Model model)
	{
		List<Employee> empList=employeeService.getList();
		model.addAttribute("elist",empList);
		return "admin/edittime/in/employee-list";
	}
	@RequestMapping("edit-intime")
	public String editEmployeeIntime(int weid,int reid)
	{
		editTimeService.updateInTime(weid,reid);
		return "admin/edittime/in/in-updated";
	}
}
