package com.cetpa.user.repositories;

import java.time.LocalDate;
import java.util.List;

import com.cetpa.admin.entities.TimeInfo;

public interface TimeinfoRepository 
{
	void saveOuttime(TimeInfo timeinfo);
	TimeInfo getTimeInfo(int eid);
	void updateEmployeeIntime(TimeInfo timeInfo, String intime, String totaltime);
	void editEmployeeId(TimeInfo timeinfo,int reid);
	TimeInfo getWTimeInfo(int weid);
	void editIntimeEntry(TimeInfo rtimeinfo, TimeInfo wtimeinfo, String intime, String totaltime);
	List<TimeInfo> getCAList(LocalDate now);
	List<TimeInfo> getDateBetweenList(LocalDate ldate1, LocalDate ldate2);
}
