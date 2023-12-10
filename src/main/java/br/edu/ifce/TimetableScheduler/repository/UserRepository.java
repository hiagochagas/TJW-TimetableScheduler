package br.edu.ifce.TimetableScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifce.TimetableScheduler.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.login LIKE :login")
	User fetchUserByLogin(String login);
}
