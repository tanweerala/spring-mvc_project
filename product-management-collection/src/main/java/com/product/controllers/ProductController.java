package com.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.models.Product;
import com.product.services.ProductService;

@Controller
public class ProductController 
{
	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String getHomeView()
	{
		return "home.jsp";
	}
	@RequestMapping("/add")
	public String getAddProductView()
	{
		return "insert.jsp";
	}
	@RequestMapping("/save-record")
	public String saveProductRecord(Product product)
	{
		service.addProduct(product);
		return "save.jsp";
	}
	@RequestMapping("/list")
	public String getProductList(Model model)
	{
		List<Product> plist=service.getList();
		model.addAttribute("productList", plist);
		return "list.jsp";
	}
	@RequestMapping("/search")
	public String getSearchProductView()
	{
		return "search.jsp";
	}
	@RequestMapping("/search-record")
	public String searchProductRecord(int pid,Model model)
	{
		Product p=service.getProduct(pid);
		if(p==null)
		{
			model.addAttribute("msg","Product with id "+pid+" not found");
			return "search.jsp";
		}
		model.addAttribute("product",p);
		return "show.jsp";
	}
	@RequestMapping("/delete")
	public String getDeleteProductView()
	{
		return "delete.jsp";
	}
	@RequestMapping("/delete-record")
	public String deleteProductRecord(int pid,Model model)
	{
		Product p=service.getProduct(pid);
		if(p==null)
		{
			model.addAttribute("msg","Product with id "+pid+" doest not exist");
			return "delete.jsp";
		}
		service.deleteRecord(p);
		model.addAttribute("msg","Product with id "+pid+" has been deleted");
		return "delete.jsp";
	}
}
