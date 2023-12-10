package br.edu.ifce.TimetableScheduler.service;

import br.edu.ifce.TimetableScheduler.model.User;

public interface UserService {
	User fetchUserByLogin (String login);
	User save(User user);
}
