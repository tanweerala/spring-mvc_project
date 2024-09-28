package com.cetpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController 
{
	@RequestMapping("/")
	public String getLoginView()
	{
		return "login.jsp";
	}
	@RequestMapping("login-authentication")
	public String authenticateUser(String username,String password,Model model)
	{
		if(username.equals("admin") && password.equals("cetpa"))
			return "home.jsp";
		model.addAttribute("name",username);
		model.addAttribute("msg","Username or password is incorrect");
		return "login.jsp";
	}
}
