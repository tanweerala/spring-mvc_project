package com.cetpa.user.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.entities.Account;
import com.cetpa.admin.services.AccountService;

@Controller
@RequestMapping("tracker")
public class TrackerHomeController 
{
	@Autowired private AccountService accountService;
	
	@RequestMapping("home")
	public String getHomeView(HttpSession ses)
	{
		if(ses.getAttribute("uid")==null)
			return "redirect:login";
		return "tracker/home";
	}
	@RequestMapping("login")
	public String getLoginView(HttpSession ses)
	{
		if(ses.getAttribute("uid")==null)
			return "tracker/login";
		return "redirect:home";
	}
	@RequestMapping("authenticate-user")
	public String authenticateUser(String userid,String pass,Model model,HttpSession ses)
	{
		Account account=accountService.getAccountByUserid(userid);
		model.addAttribute("uid",userid);
		if(account==null)
		{
			model.addAttribute("msg","User id does not exist...");
			return "tracker/login";
		}
		String dpass=account.getPassword();
		if(!pass.equals(dpass))
		{
			model.addAttribute("msg","Password is wrong...");
			return "tracker/login";
		}
		ses.setAttribute("uid",userid);
		ses.setAttribute("name",account.getName());
		return "redirect:home";
	}
	@RequestMapping("logout")
	public String logoutAdmin(HttpSession ses)
	{
		if(ses.getAttribute("uid")==null)
			return "redirect:login";
		ses.invalidate();
		return "redirect:login";
	}
}
