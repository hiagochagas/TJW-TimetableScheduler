package br.edu.ifce.TimetableScheduler.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.TimetableScheduler.exceptions.ProfessorNotFoundException;
import br.edu.ifce.TimetableScheduler.model.Professor;
import br.edu.ifce.TimetableScheduler.repository.ProfessorRepository;
import br.edu.ifce.TimetableScheduler.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {
	
	@Autowired
	ProfessorRepository repository;
	
	@Override
	public Professor save(Professor professor) {
		return repository.save(professor);
	}

	@Override
	public Professor fetchProfessorById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ProfessorNotFoundException(id));
	}

	@Override
	public List<Professor> fetchAll() {
		return repository.findAll();
	}

	@Override
	public Professor editProfessor(Professor newProfessor) {
		return save(newProfessor);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
