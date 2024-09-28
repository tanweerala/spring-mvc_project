package com.cetpa.utiltiy;

import java.time.LocalTime;

public class TimeUtiltiy 
{
	public static String getCurrentTime()
	{
		LocalTime lt=LocalTime.now();
		String time=lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond();
		return time;
	}

	public static String getTotalTime(String intime, String outtime) 
	{
		int v1=timeInSeconds(intime);
		int v2=timeInSeconds(outtime);
		int v3=v1-v2;
		int m=v3/60;
		int s=v3%60;
		String total=m+" min and "+s+" sec";
		return total;
	}
	private static int timeInSeconds(String time)
	{
		String[] x=time.split(":");
		int total=Integer.parseInt(x[0])*3600+Integer.parseInt(x[1])*60+Integer.parseInt(x[2]);
		return total;
	}
}
