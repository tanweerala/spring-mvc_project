package com.cetpa.user.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.admin.entities.TimeInfo;
import com.cetpa.admin.repositories.EmployeeRepository;
import com.cetpa.user.repositories.TimeinfoRepository;
import com.cetpa.user.services.TimeinService;
import com.cetpa.utiltiy.TimeUtiltiy;

@Service
public class TimeinServiceImpl implements TimeinService 
{
	@Autowired private TimeinfoRepository  timeinfoRepository;
	@Autowired private EmployeeRepository employeeRespository;
	public void updateIntime(int eid) 
	{
		TimeInfo timeInfo=timeinfoRepository.getTimeInfo(eid);
		String outtime=timeInfo.getOuttime();
		String intime=TimeUtiltiy.getCurrentTime();
		String totaltime=TimeUtiltiy.getTotalTime(intime,outtime);
		timeinfoRepository.updateEmployeeIntime(timeInfo,intime,totaltime);
		employeeRespository.updateEmployeeStatus("in",eid);
	}
}
