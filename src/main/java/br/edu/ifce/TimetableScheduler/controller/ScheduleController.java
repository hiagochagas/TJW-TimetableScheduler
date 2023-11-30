package br.edu.ifce.TimetableScheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifce.TimetableScheduler.model.Schedule;
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
	
	@GetMapping("/register")
	String register(ModelMap model) {
		model.addAttribute("schedule", new Schedule());
		return "/schedule/register";
	}
	
	@PostMapping("/save")
	String save(Schedule schedule) {
		service.save(schedule);
		return "redirect:/schedule/list";
	}
	
	@GetMapping("/edit/{id}")
	String preEdit(@PathVariable("id") Long id, ModelMap model){
		model.addAttribute("schedule",service.fetchScheduleById(id));
		return "/schedule/register";
	}
	
	@GetMapping("/delete/{id}")
	String delete(@PathVariable("id") Long id, ModelMap model){
		service.deleteById(id);
		return "redirect:/schedule/list";
	}
	
	
	@PostMapping("/edit")
	String edit(Schedule schedule) {
		service.editSchedule(schedule);
		return "redirect:/schedule/list";
	}
}
