package br.edu.ifce.TimetableScheduler.service;

import java.util.List;

import br.edu.ifce.TimetableScheduler.model.Schedule;

public interface ScheduleService {
	Schedule save(Schedule schedule);

	Schedule fetchScheduleById(Long id);

	List<Schedule> fetchAll();

	Schedule editSchedule(Schedule newSchedule);
	
	void deleteById(Long id);
}
