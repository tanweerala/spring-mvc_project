package com.cetpa.user.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.entities.TimeInfo;
import com.cetpa.user.services.DatewiseReportService;

@Controller
@RequestMapping("tracker/reports/datewise")
public class DatewiseReportController 
{
	@Autowired private DatewiseReportService datewiseReportService;
	
	@RequestMapping("date")
	public String getChooseDateView(Model model)
	{
		model.addAttribute("cdate",LocalDate.now());
		return "tracker/reports/datewise/choose-date";
	}
	@RequestMapping("current")
	public String getCurrentDateReport(Model model)
	{
		List<TimeInfo> tlist=datewiseReportService.getCurrentDateList();
		model.addAttribute("list",tlist);
		return "tracker/reports/datewise/current-date";
	}
	@RequestMapping("any")
	public String getAnyDateReport(String date,Model model)
	{
		List<TimeInfo> tlist=datewiseReportService.geAnyDateList(date);
		model.addAttribute("list",tlist);
		model.addAttribute("date",date);
		return "tracker/reports/datewise/any-date";
	}
	@RequestMapping("date-between")
	public String getDateBetweenReport(String date1,String date2,Model model)
	{
		List<TimeInfo> tlist=datewiseReportService.geDateBetweenList(date1,date2);
		model.addAttribute("list",tlist);
		model.addAttribute("date1",date1);
		model.addAttribute("date2",date2);
		return "tracker/reports/datewise/date-between";
	}
}
