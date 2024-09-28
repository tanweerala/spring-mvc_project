package com.cetpa.admin.services;

import java.util.List;

import com.cetpa.admin.entities.Account;

public interface AccountService 
{
	List<Account> getList();
	Account getAccountByPhone(String phone);
	void createAccount(Account account);
	Account getAccountByUserid(String userid);
}
