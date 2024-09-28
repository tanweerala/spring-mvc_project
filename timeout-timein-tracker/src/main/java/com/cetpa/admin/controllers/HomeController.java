package com.cetpa.admin.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class HomeController 
{
	@RequestMapping("home")
	public String getHomeView(HttpSession ses)
	{
		if(ses.getAttribute("id")==null)
			return "redirect:login";
		return "admin/home";
	}
	@RequestMapping("login")
	public String getLoginView(HttpSession ses)
	{
		if(ses.getAttribute("id")==null)
			return "admin/login";
		return "redirect:home";
	}
	@RequestMapping("authenticate-user")
	public String authenticateAdmin(String adminid,String pass,Model model,HttpSession ses)
	{
		if(adminid.equals("admin") && pass.equals("cetpa"))
		{
			ses.setAttribute("id",adminid);
			return "redirect:home";
		}
		model.addAttribute("id",adminid);
		model.addAttribute("msg","Authentication failed...");
		return "admin/login";
	}
	@RequestMapping("logout")
	public String logoutAdmin(HttpSession ses)
	{
		if(ses.getAttribute("id")==null)
			return "redirect:login";
		ses.invalidate();
		return "redirect:login";
	}
}
