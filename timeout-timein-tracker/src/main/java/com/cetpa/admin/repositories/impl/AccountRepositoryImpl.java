package com.cetpa.admin.repositories.impl;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cetpa.admin.entities.Account;
import com.cetpa.admin.repositories.AccountRepository;

@Repository
public class AccountRepositoryImpl implements AccountRepository 
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public AccountRepositoryImpl(SessionFactory sessionFactory)
	{
		session=sessionFactory.openSession();
		transaction=session.getTransaction(); 
	}
	public List<Account> getAccountList() 
	{
		Query<Account> query=session.createQuery("from Account",Account.class);
		return query.list();
	}
	public Account getAccountByPhone(String phone) 
	{
		Query<Account> query=session.createQuery("from Account where phone=:arg",Account.class);
		query.setParameter("arg",phone);
		return query.uniqueResult();
	}
	public void createAccount(Account account) 
	{
		transaction.begin();
		session.save(account);
		transaction.commit();
	}
	public Account getAccountById(String userid) 
	{
		return session.get(Account.class,userid);
	}
}
