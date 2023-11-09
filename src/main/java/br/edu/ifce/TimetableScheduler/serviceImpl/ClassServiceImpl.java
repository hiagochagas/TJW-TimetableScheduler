package br.edu.ifce.TimetableScheduler.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifce.TimetableScheduler.exceptions.ClassNotFoundException;
import br.edu.ifce.TimetableScheduler.model.Class;
import br.edu.ifce.TimetableScheduler.repository.ClassRepository;
import br.edu.ifce.TimetableScheduler.service.ClassService;

public class ClassServiceImpl implements ClassService {

	@Autowired
	ClassRepository repository;
	
	@Override
	public Class save(Class c) {
		return repository.save(c);
	}

	@Override
	public Class fetchClassById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ClassNotFoundException(id));
	}

	@Override
	public List<Class> fetchAll() {
		return repository.findAll();
	}

	@Override
	public Class editClass(Long id, Class newClass) {
		Class c = fetchClassById(id);
		c.setProfessor(newClass.getProfessor());
		c.setDiscipline(newClass.getDiscipline());
		c.setSchedule(newClass.getSchedule());
		return save(c);
	}

}
