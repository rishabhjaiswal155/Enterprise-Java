package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
public UserController() {
System.out.println("in ctor of "+getClass());
}
@GetMapping("/login")
public String showLoginForm() {
	System.out.println("in showLoginForm() of "+getClass());
	return "/user/login";
}

@PostMapping("/login")
public String processLoginForm(@RequestParam String email,@RequestParam String password,Model map,HttpSession session,RedirectAttributes flashmap) {
	System.out.println("in processLoginForm() of "+getClass()+" "+email+" "+password+" "+map);
	try {
	User authenticateUser=userService.authenticateUser(email, password);
	flashmap.addFlashAttribute("msg", "Login Sucessfull");
	session.setAttribute("user_dtls",authenticateUser);
	if(authenticateUser.getRoles().contains(new Role(UserRole.ADMIN))) {
		return "redirect:/admin/status";
	}
	if(authenticateUser.getRoles().contains(new Role(UserRole.CUSTOMER))) {
		return "redirect:/customer/topics";
	}
	return "/author/success";
	
	}catch(RuntimeException e) {
		System.out.println("got exception in "+getClass()+" "+e);
		map.addAttribute("msg","Invalid Login details....Please try again....");
		return "/user/login";
	}
	}

}
