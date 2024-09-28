package com.product.repositories;

import java.util.*;
import org.springframework.stereotype.Repository;
import com.product.models.Product;

@Repository
public class ProductRepository 
{
	List<Product> productList=new ArrayList<Product>();

	public void saveProduct(Product product)
	{
		productList.add(product);
	}
	public List<Product> getProductList() 
	{
		return productList;
	}
	public Product getProductRecord(int pid) 
	{
		for(Product p:productList)
		{
			if(p.getPid()==pid)
				return p;
		}
		return null;
	}
	public void deleteProductRecord(Product p) 
	{
		productList.remove(p);
	}
}
