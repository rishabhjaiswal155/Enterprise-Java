package com.app.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/")
	public String showIndexPage() {
		System.out.println("In showIndexPage() of "+getClass());
		return "/index";
	}

}
