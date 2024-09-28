package com.cetpa.admin.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.admin.entities.Account;
import com.cetpa.admin.services.AccountService;

@Controller
@RequestMapping("admin/account")
public class AccountController
{
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("dashboard")
	public String getUserDashboard(Model model,HttpSession ses)
	{
		if(ses.getAttribute("id")==null)
		{
			return "redirect:admin/login";
		}
		List<Account> accountList=accountService.getList();
		model.addAttribute("alist",accountList);
		return "admin/account/account-dashboard";
	}
	@RequestMapping("add")
	public String getAddUserView()
	{
		return "admin/account/create-account";
	}
	@RequestMapping("save-record")
	public String saveUserRecord(Account account,Model model)
	{
		Account user1=accountService.getAccountByUserid(account.getUserid());
		if(user1!=null)
		{
			model.addAttribute("msg","User with id "+account.getUserid()+" already exists");
			return "admin/account/create-account";
		}
		user1=accountService.getAccountByPhone(account.getPhone());
		if(user1!=null)
		{
			model.addAttribute("msg","User with phone number "+account.getPhone()+" already registered");
			return "admin/account/create-account";
		}
		accountService.createAccount(account);
		return "redirect:dashboard";
	}
}
