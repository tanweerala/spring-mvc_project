package com.cetpa.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.entities.Employee;
import com.cetpa.admin.entities.TimeInfo;
import com.cetpa.admin.services.EmployeeService;
import com.cetpa.user.services.TimeinService;
import com.cetpa.user.services.TimeoutService;

@Controller
@RequestMapping("tracker/timein")
public class TimeinController 
{
	@Autowired private EmployeeService employeeService;
	@Autowired private TimeinService timeinService; 
	
	@RequestMapping("elist")
	public String getEmployeeList(Model model)
	{
		List<Employee> empList=employeeService.getList("out");
		model.addAttribute("elist",empList);
		return "tracker/time/in/employee-list";
	}
	@RequestMapping("update-intime")
	public String updateEmployeeIntime(int eid)
	{
		timeinService.updateIntime(eid);
		return "tracker/time/in/intime-updated";
	}
}
