package br.edu.ifce.TimetableScheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifce.TimetableScheduler.serviceImpl.ClassServiceImpl;

@Controller
public class HomeController {
	@Autowired
	ClassServiceImpl service;
	
	@GetMapping("/")
	public String home(ModelMap model) {
		model.addAttribute("classes", service.fetchAll());
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
}
