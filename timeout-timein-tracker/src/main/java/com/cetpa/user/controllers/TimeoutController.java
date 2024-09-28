package com.cetpa.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.entities.Employee;
import com.cetpa.admin.entities.TimeInfo;
import com.cetpa.admin.services.EmployeeService;
import com.cetpa.user.services.TimeoutService;

@Controller
@RequestMapping("tracker/timeout")
public class TimeoutController 
{
	@Autowired private EmployeeService employeeService;
	@Autowired private TimeoutService timeoutService; 
	
	@RequestMapping("elist")
	public String getEmployeeList(Model model)
	{
		List<Employee> empList=employeeService.getList("in");
		model.addAttribute("elist",empList);
		return "tracker/time/out/employee-list";
	}
	@RequestMapping("record-outtime")
	public String recordEmployeeOuttime(TimeInfo timeinfo)
	{
		timeoutService.recordTime(timeinfo);
		return "tracker/time/out/outtime-saved";
	}
}
