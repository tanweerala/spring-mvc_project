package com.cetpa.user.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.admin.entities.TimeInfo;
import com.cetpa.user.repositories.TimeinfoRepository;
import com.cetpa.user.services.DatewiseReportService;

@Service
public class DatewiseReportServiceImpl implements DatewiseReportService 
{
	@Autowired private TimeinfoRepository timeinfoRepository;

	public List<TimeInfo> getCurrentDateList() 
	{
		return timeinfoRepository.getCAList(LocalDate.now());
	}
	public List<TimeInfo> geAnyDateList(String date) 
	{
		LocalDate ldate=LocalDate.parse(date);
		return timeinfoRepository.getCAList(ldate);
	}
	public List<TimeInfo> geDateBetweenList(String date1, String date2) 
	{
		LocalDate ldate1=LocalDate.parse(date1);
		LocalDate ldate2=LocalDate.parse(date2);
		return timeinfoRepository.getDateBetweenList(ldate1,ldate2);
	}
}
