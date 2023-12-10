package br.edu.ifce.TimetableScheduler.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.TimetableScheduler.model.User;
import br.edu.ifce.TimetableScheduler.repository.UserRepository;
import br.edu.ifce.TimetableScheduler.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Override
	public User fetchUserByLogin(String login) {
		return repository.fetchUserByLogin(login);
	}

	@Override
	public User save(User user) {
		return repository.save(user);
	}

}
