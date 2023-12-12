package br.edu.ifce.TimetableScheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifce.TimetableScheduler.model.User;
import br.edu.ifce.TimetableScheduler.serviceImpl.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	
	private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	@GetMapping("/signup")
	public String signUp(ModelMap model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@PostMapping("/signup") 
	public String signup(User user) {
		if (service.fetchUserByLogin(user.getLogin()) != null) {
			return "redirect:login";
		}
		String uncryptedPassword = user.getPassword();
		user.setPassword(passwordEncoder.encode(uncryptedPassword));
		service.save(user);
		return "redirect:login";
	}
}
