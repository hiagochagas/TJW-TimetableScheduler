package br.edu.ifce.TimetableScheduler.service;

import java.util.List;

import br.edu.ifce.TimetableScheduler.model.Professor;

public interface ProfessorService {
	Professor save(Professor professor);

	Professor fetchProfessorById(Long id);

	List<Professor> fetchAll();

	Professor editProfessor(Long id, Professor newProfessor);
}
