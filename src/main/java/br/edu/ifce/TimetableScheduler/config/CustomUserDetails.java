package br.edu.ifce.TimetableScheduler.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.ifce.TimetableScheduler.model.User;
import br.edu.ifce.TimetableScheduler.serviceImpl.UserServiceImpl;

public class CustomUserDetails implements UserDetailsService {

	@Autowired
	UserServiceImpl service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = service.fetchUserByLogin(username);
		String[] authorities = new String[1];
		authorities[0] = "ROLE_USER";

		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
				AuthorityUtils.createAuthorityList(authorities));
	}

}
