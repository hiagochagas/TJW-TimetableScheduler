package br.edu.ifce.TimetableScheduler.service;

import java.util.List;

import br.edu.ifce.TimetableScheduler.model.Class;

public interface ClassService {
	Class save(Class c);

	Class fetchClassById(Long id);

	List<Class> fetchAll();

	Class editClass(Long id, Class newClass);
}
