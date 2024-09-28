package com.cetpa.admin.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.admin.entities.Account;
import com.cetpa.admin.repositories.AccountRepository;
import com.cetpa.admin.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService 
{
	@Autowired private AccountRepository  accountRepository;

	public List<Account> getList() 
	{
		return accountRepository.getAccountList();
	}
	public Account getAccountByPhone(String phone) 
	{
		return accountRepository.getAccountByPhone(phone);
	}
	public void createAccount(Account account) 
	{
		accountRepository.createAccount(account);
	}
	public Account getAccountByUserid(String userid) 
	{
		return accountRepository.getAccountById(userid);
	}
}
