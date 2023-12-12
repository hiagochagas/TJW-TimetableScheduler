package br.edu.ifce.TimetableScheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifce.TimetableScheduler.model.User;
import br.edu.ifce.TimetableScheduler.serviceImpl.UserServiceImpl;

@SpringBootApplication
public class TimetableSchedulerApplication implements CommandLineRunner {
	
	@Autowired
	UserServiceImpl service;
	
	public static void main(String[] args) {
		SpringApplication.run(TimetableSchedulerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

	}
}
