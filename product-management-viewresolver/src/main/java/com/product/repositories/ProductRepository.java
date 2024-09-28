package com.product.repositories;

import java.util.*;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.product.models.Product;

@Repository
public class ProductRepository 
{
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public ProductRepository(SessionFactory factory)
	{
		this.factory=factory;
		session=factory.openSession();
		transaction=session.getTransaction();
	}
	public void saveProduct(Product product)
	{
		transaction.begin();
		session.save(product);
		transaction.commit();
	}
	public List<Product> getProductList() 
	{
		Query<Product> query=session.createQuery("from Product",Product.class);
		return query.list();
	}
	public Product getProductRecord(int pid) 
	{
		Product product=session.get(Product.class,pid);
		return product;
	}
	public void deleteProductRecord(Product p) 
	{
		transaction.begin();
		session.delete(p);
		transaction.commit();
	}
	public void updateProduct(Product producto, Product productn) 
	{
		transaction.begin();
		producto.setName(productn.getName());
		producto.setBrand(productn.getBrand());
		producto.setPrice(productn.getPrice());
		transaction.commit();
	}
}
