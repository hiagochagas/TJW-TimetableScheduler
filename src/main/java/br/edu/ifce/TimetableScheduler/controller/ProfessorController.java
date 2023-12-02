package br.edu.ifce.TimetableScheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifce.TimetableScheduler.model.Professor;
import br.edu.ifce.TimetableScheduler.serviceImpl.DisciplineServiceImpl;
import br.edu.ifce.TimetableScheduler.serviceImpl.ProfessorServiceImpl;
import br.edu.ifce.TimetableScheduler.serviceImpl.ScheduleServiceImpl;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
	@Autowired
	ProfessorServiceImpl service;
	@Autowired
	DisciplineServiceImpl disciplineService;
	@Autowired
	ScheduleServiceImpl scheduleService;

	@GetMapping("/list")
	String listAll(ModelMap model) {
		model.addAttribute("professors", service.fetchAll());
		return "/professor/list";
	}

	@GetMapping("/register")
	String register(ModelMap model) {
		model.addAttribute("professor", new Professor());
		model.addAttribute("allDisciplines", disciplineService.fetchAll());
		model.addAttribute("allSchedules", scheduleService.fetchAll());
		return "/professor/register";
	}

	@PostMapping("/save")
	String save(Professor professor) {
		service.save(professor);
		return "redirect:/professor/list";
	}

	@GetMapping("/edit/{id}")
	String preEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("professor", service.fetchProfessorById(id));
		model.addAttribute("allDisciplines", disciplineService.fetchAll());
		model.addAttribute("allSchedules", scheduleService.fetchAll());
		return "/professor/register";
	}

	@GetMapping("/delete/{id}")
	String delete(@PathVariable("id") Long id, ModelMap model) {
		service.deleteById(id);
		return "redirect:/professor/list";
	}

	@PostMapping("/edit")
	String edit(Professor professor) {
		service.editProfessor(professor);
		return "redirect:/professor/list";
	}
}
