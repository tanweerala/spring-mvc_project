package com.cetpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController 
{
	//url of this handler-->http://localhost:8080/mvc-demo/home
	@RequestMapping("home")
	public String getHomeView()
	{
		return "home.jsp";
	}
}
