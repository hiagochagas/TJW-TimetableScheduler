package br.edu.ifce.TimetableScheduler.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.TimetableScheduler.exceptions.DisciplineNotFoundException;
import br.edu.ifce.TimetableScheduler.model.Discipline;
import br.edu.ifce.TimetableScheduler.repository.DisciplineRepository;
import br.edu.ifce.TimetableScheduler.service.DisciplineService;

@Service
public class DisciplineServiceImpl implements DisciplineService {

	@Autowired
	DisciplineRepository repository;

	@Override
	public Discipline save(Discipline discipline) {
		return repository.save(discipline);
	}

	@Override
	public Discipline fetchDisciplineById(Long id) {
		return repository.findById(id).orElseThrow(() -> new DisciplineNotFoundException(id));
	}
	
	@Override
	public List<Discipline> fetchAll() {
		return repository.findAll();
	}
	
	@Override
	public Discipline editDiscipline(Discipline newDiscipline) {
		return save(newDiscipline);
	}
	
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
