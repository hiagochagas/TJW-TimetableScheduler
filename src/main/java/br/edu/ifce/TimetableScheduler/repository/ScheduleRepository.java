package br.edu.ifce.TimetableScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifce.TimetableScheduler.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
