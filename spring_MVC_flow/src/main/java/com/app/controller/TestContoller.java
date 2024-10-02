package com.app.controller;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//singlton and eager
@Controller//mandatory
@RequestMapping("/test")//optional
public class TestContoller {
	public TestContoller() {
	System.out.println("in ctr of "+getClass());
	}
	
	@PostConstruct
	public void anyInit() {
		System.out.println("in init of "+getClass());
	}
	
	@PreDestroy
	public void anyDestroy() {
		System.out.println("in destroy of "+getClass());
	}
	
	@GetMapping("/test1")
	public ModelAndView testModelAndView() {
		System.out.println("in testModelAndView method of "+getClass());
		return new ModelAndView("/test/test1","server_ts",LocalDateTime.now());
	}

}
