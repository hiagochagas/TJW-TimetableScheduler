package br.edu.ifce.TimetableScheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifce.TimetableScheduler.serviceImpl.ScheduleServiceImpl;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	ScheduleServiceImpl service;
	
	@GetMapping("/list")
	String listAll(ModelMap model) {
		model.addAttribute("schedules", service.fetchAll());
		return "/schedule/list";
	}
}
