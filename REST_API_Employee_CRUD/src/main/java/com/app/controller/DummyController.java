package com.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyController {
public DummyController() {	
System.out.println("in ctor of "+getClass());
}

//Rest end point
@GetMapping
public List<Integer> getListOfNumbers(){
	System.out.println("in getListOfNumbers() of "+getClass());
	return List.of(10,20,30,40,50);
}
}
