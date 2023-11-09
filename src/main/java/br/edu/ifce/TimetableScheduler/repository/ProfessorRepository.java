package br.edu.ifce.TimetableScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifce.TimetableScheduler.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
