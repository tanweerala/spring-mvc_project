package com.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.models.Product;
import com.product.repositories.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository repo;

	public void addProduct(Product product) 
	{
		repo.saveProduct(product);
	}
	public List<Product> getList() 
	{
		return repo.getProductList();
	}
	public Product getProduct(int pid) 
	{
		return repo.getProductRecord(pid);
	}
	public void deleteRecord(Product p) 
	{
		repo.deleteProductRecord(p);
	}
}
