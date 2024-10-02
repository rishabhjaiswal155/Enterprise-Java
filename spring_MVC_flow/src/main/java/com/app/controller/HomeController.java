package com.app.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//singleton and eager
@Controller
public class HomeController {
	public HomeController() {
	System.out.println("in ctor of "+getClass());	
	}
	@PostConstruct
	public void anyInit() {
		System.out.println("in init of "+getClass());
	}
	@PreDestroy
	public void anyDestroy() {
		System.out.println("in destroy of "+getClass());
	}
	
	//request handling method
	@RequestMapping("/hello")
	public String sayHello1() {
		System.out.println("in sayHello1 method of "+getClass());
		return "/welcome";//handler returns Logical view name to d.s
		//D.s forward it to  view resolver and view resolver convert logical view name to actual view name and forward it to d.s
	}
	
	//request handling method for index
	@GetMapping("/")
	public String showIndexPage() {
		System.out.println("in showIndexPage() of "+getClass());
		return "/index";
	}

}
