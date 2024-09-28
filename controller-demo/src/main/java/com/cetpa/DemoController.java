package com.cetpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController 
{
	@RequestMapping("cetpa")
	public String method1()
	{
		System.out.println("Method1 called...");
		return "aa.jsp";
	}
	@RequestMapping("m2")
	public String method2()
	{
		System.out.println("Method2 called...");
		return "aa.jsp";
	}
	@RequestMapping("m3")
	public String method3()
	{
		System.out.println("Method3 called...");
		return "aa.jsp";
	}
}
