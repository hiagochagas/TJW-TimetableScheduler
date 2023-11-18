package br.edu.ifce.TimetableScheduler.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.TimetableScheduler.exceptions.ScheduleNotFoundException;
import br.edu.ifce.TimetableScheduler.model.Schedule;
import br.edu.ifce.TimetableScheduler.repository.ScheduleRepository;
import br.edu.ifce.TimetableScheduler.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	ScheduleRepository repository;
	
	
	@Override
	public Schedule save(Schedule schedule) {
		return repository.save(schedule);
	}

	@Override
	public Schedule fetchScheduleById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ScheduleNotFoundException(id));
	}

	@Override
	public List<Schedule> fetchAll() {
		return repository.findAll();
	}

	@Override
	public Schedule editSchedule(Long id, Schedule newSchedule) {
		Schedule schedule = fetchScheduleById(id);
		schedule.setDayName(newSchedule.getDayName());
		schedule.setStartTime(newSchedule.getStartTime());
		schedule.setEndTime(newSchedule.getEndTime());
		schedule.setProfessors(newSchedule.getProfessors());
		return save(schedule);
	}

}
