package br.edu.ifce.TimetableScheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifce.TimetableScheduler.model.Schedule;
import br.edu.ifce.TimetableScheduler.repository.ScheduleRepository;

@SpringBootApplication
public class TimetableSchedulerApplication implements CommandLineRunner {
	@Autowired
	ScheduleRepository r;
	
	public static void main(String[] args) {
		SpringApplication.run(TimetableSchedulerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Schedule s = new Schedule();
		s.setDayName("Segunda");
		s.setStartTime("8:00");
		s.setEndTime("9:00");
		
		r.save(s);
	}

}
