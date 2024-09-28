package com.cetpa.user.repositories.impl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.cetpa.admin.entities.TimeInfo;
import com.cetpa.user.repositories.TimeinfoRepository;

@Repository
public class TimeinfoRepositoryImpl implements TimeinfoRepository 
{
	private Session session;
	private Transaction transaction;
	public TimeinfoRepositoryImpl(SessionFactory factory)
	{
		session=factory.openSession();
		transaction=session.getTransaction();
	}
	public void saveOuttime(TimeInfo timeinfo) 
	{
		transaction.begin();
		session.save(timeinfo);
		transaction.commit();
	}
	public TimeInfo getTimeInfo(int eid) 
	{
		Query<TimeInfo> query=session.createQuery("from TimeInfo where eid=:arg1 and intime=:arg2",TimeInfo.class);
		query.setParameter("arg1",eid);
		query.setParameter("arg2","Not in yet");
		return query.uniqueResult();
	}
	public void updateEmployeeIntime(TimeInfo timeInfo, String intime, String totaltime) 
	{
		transaction.begin();
		timeInfo.setIntime(intime);
		timeInfo.setTotaltime(totaltime);
		transaction.commit();
	}
	public void editEmployeeId(TimeInfo timeinfo,int reid) 
	{
		transaction.begin();
		timeinfo.setEid(reid);
		transaction.commit();
	}
	public TimeInfo getWTimeInfo(int weid) 
	{
		Query<TimeInfo> query=session.createQuery("from TimeInfo where eid=:arg1 and date=:arg2",TimeInfo.class);
		query.setParameter("arg1",weid);
		query.setParameter("arg2",LocalDate.now());
		List<TimeInfo> list=query.list();
		return list.get(list.size()-1);
	}
	public void editIntimeEntry(TimeInfo rtimeinfo, TimeInfo wtimeinfo, String intime, String totaltime) 
	{
		transaction.begin();
		rtimeinfo.setIntime(intime);
		rtimeinfo.setTotaltime(totaltime);
		wtimeinfo.setIntime("Not in yet");
		wtimeinfo.setTotaltime("Not applicable");
		transaction.commit();
	}
	public List<TimeInfo> getCAList(LocalDate date) 
	{
		Query<TimeInfo> query=session.createQuery("from TimeInfo where date=:arg",TimeInfo.class);
		query.setParameter("arg",date);
		return query.list();
	}
	public List<TimeInfo> getDateBetweenList(LocalDate date1, LocalDate date2) 
	{
		Query<TimeInfo> query=session.createQuery("from TimeInfo where date between :arg1 and :arg2",TimeInfo.class);
		query.setParameter("arg1",date1);
		query.setParameter("arg2",date2);
		return query.list();
	}
}
