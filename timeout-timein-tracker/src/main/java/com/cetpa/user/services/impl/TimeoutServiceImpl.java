package com.cetpa.user.services.impl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.admin.entities.TimeInfo;
import com.cetpa.admin.repositories.EmployeeRepository;
import com.cetpa.user.repositories.TimeinfoRepository;
import com.cetpa.user.services.TimeoutService;
import com.cetpa.utiltiy.TimeUtiltiy;

@Service
public class TimeoutServiceImpl implements TimeoutService 
{
	@Autowired private TimeinfoRepository  timeinfoRepository;
	@Autowired private EmployeeRepository employeeRespository;

	public void recordTime(TimeInfo timeinfo) 
	{
		String time=TimeUtiltiy.getCurrentTime();
		timeinfo.setOuttime(time);
		LocalDate date=LocalDate.now();
		timeinfo.setDate(date);
		timeinfoRepository.saveOuttime(timeinfo);
		employeeRespository.updateEmployeeStatus("out",timeinfo.getEid());
	}
}
