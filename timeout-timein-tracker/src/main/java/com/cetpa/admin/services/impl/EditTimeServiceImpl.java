package com.cetpa.admin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.admin.entities.TimeInfo;
import com.cetpa.admin.repositories.EmployeeRepository;
import com.cetpa.admin.services.EditTimeService;
import com.cetpa.user.repositories.TimeinfoRepository;
import com.cetpa.utiltiy.TimeUtiltiy;

@Service
public class EditTimeServiceImpl implements EditTimeService 
{
	@Autowired private TimeinfoRepository  timeinfoRepository;
	@Autowired private EmployeeRepository employeeRespository;
	
	public void updateOutTime(int weid, int reid) 
	{
		TimeInfo timeinfo=timeinfoRepository.getTimeInfo(weid);
		timeinfoRepository.editEmployeeId(timeinfo,reid);
		employeeRespository.updateEmployeeStatus("in", weid);
		employeeRespository.updateEmployeeStatus("out", reid);
	}
	public void updateInTime(int weid, int reid) 
	{
		TimeInfo rtimeinfo=timeinfoRepository.getTimeInfo(reid);
		TimeInfo wtimeinfo=timeinfoRepository.getWTimeInfo(weid);
		String intime=wtimeinfo.getIntime();
		String outtime=rtimeinfo.getOuttime();
		String totaltime=TimeUtiltiy.getTotalTime(intime,outtime);
		timeinfoRepository.editIntimeEntry(rtimeinfo,wtimeinfo,intime,totaltime);
		employeeRespository.updateEmployeeStatus("out", weid);
		employeeRespository.updateEmployeeStatus("in", reid);
	}
}
