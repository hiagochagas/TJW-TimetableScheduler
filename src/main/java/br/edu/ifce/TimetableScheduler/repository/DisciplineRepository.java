package br.edu.ifce.TimetableScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifce.TimetableScheduler.model.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long>{

}
