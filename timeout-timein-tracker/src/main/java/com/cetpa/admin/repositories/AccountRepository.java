package com.cetpa.admin.repositories;

import java.util.List;

import com.cetpa.admin.entities.Account;

public interface AccountRepository 
{
	List<Account> getAccountList();
	Account getAccountByPhone(String phone);
	void createAccount(Account account);
	Account getAccountById(String userid);
}
