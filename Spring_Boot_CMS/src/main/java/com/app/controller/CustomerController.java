package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.ITopicDao;
import com.app.service.ITutorialService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ITopicDao topicDao;
	@Autowired
	private ITutorialService tutorialService;
	
	public CustomerController() {
	System.out.println("In ctor of "+getClass());
	}
	
	@GetMapping("/topics")
	public String showTopicsPage(Model map) {
		System.out.println("in showTopicsPage() of "+getClass());
		map.addAttribute("topic_dtls",topicDao.getAllTopicName());
		return "/customer/topics";
	}
	
	@GetMapping("/tutorials")
	public String showTutorialNames(@RequestParam Long topicId,Model map) {
		System.out.println("in showTutorialNames() of "+getClass());
		map.addAttribute("tut_names",tutorialService.getAllTutorialTitle(topicId));
		return "/customer/tutorials";
	}

}
