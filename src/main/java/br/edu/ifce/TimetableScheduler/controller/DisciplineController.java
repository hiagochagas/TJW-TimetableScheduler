package br.edu.ifce.TimetableScheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifce.TimetableScheduler.model.Discipline;
import br.edu.ifce.TimetableScheduler.serviceImpl.DisciplineServiceImpl;

@Controller
@RequestMapping("/discipline")
public class DisciplineController {
	@Autowired
	DisciplineServiceImpl service;
	
	@GetMapping("/list")
	String listAll(ModelMap model) {
		model.addAttribute("disciplines", service.fetchAll());
		return "/discipline/list";
	}
	
	@GetMapping("/register")
	String register(ModelMap model) {
		model.addAttribute("discipline", new Discipline());
		return "/discipline/register";
	}
	
	@PostMapping("/save")
	String save(Discipline discipline) {
		service.save(discipline);
		return "redirect:/discipline/list";
	}
	
	@GetMapping("/edit/{id}")
	String preEdit(@PathVariable("id") Long id, ModelMap model){
		model.addAttribute("discipline",service.fetchDisciplineById(id));
		return "/discipline/register";
	}
	
	@GetMapping("/delete/{id}")
	String delete(@PathVariable("id") Long id, ModelMap model){
		service.deleteById(id);
		return "redirect:/discipline/list";
	}
	
	@PostMapping("/edit")
	String edit(Discipline discipline) {
		service.editDiscipline(discipline);
		return "redirect:/discipline/list";
	}
}
