package com.cetpa.user.services;

import java.util.List;

import com.cetpa.admin.entities.TimeInfo;

public interface DatewiseReportService 
{
	List<TimeInfo> getCurrentDateList();
	List<TimeInfo> geAnyDateList(String date);
	List<TimeInfo> geDateBetweenList(String date1, String date2);
}
