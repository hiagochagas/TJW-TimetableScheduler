package br.edu.ifce.TimetableScheduler.service;

import java.util.List;

import br.edu.ifce.TimetableScheduler.model.Discipline;

public interface DisciplineService {
	Discipline save(Discipline discipline);

	Discipline fetchDisciplineById(Long id);

	List<Discipline> fetchAll();

	Discipline editDiscipline(Discipline newDiscipline);
	
	void deleteById(Long id);
}
