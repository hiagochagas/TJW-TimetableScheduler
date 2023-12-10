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
		User user = new User();
		user.setLogin("user");
		user.setPassword("$2a$12$zJOMr1qiPAsN2d4GoE4TSeJq.AVzQb5Zco6m5JmF7QuYSC8X4jAXu");
		service.save(user);
	}
}
