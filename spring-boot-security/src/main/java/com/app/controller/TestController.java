package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {
	public TestController() {
	log.info("in default ctor");
	}
	
	@GetMapping("/home")
	public String showHome() {
	return "in home page....";	
	}

	@GetMapping("/user")
	public String showUser() {
	return "in User page....";	
	}

	@GetMapping("/admin")
	public String showAdmin() {
	return "in Admin page....";	
	}

}
