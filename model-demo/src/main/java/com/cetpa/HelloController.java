package com.cetpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController 
{
	@RequestMapping("demo")
	public String getInputView()
	{
		return "input.jsp";
	}
	@RequestMapping("sayHello")
	public String getOutputView(String str,Model model)
	{
		model.addAttribute("name",str);
		return "output.jsp";
	}
}
