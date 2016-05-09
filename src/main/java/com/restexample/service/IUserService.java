package com.restexample.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.saha.model.User;

@Service
public interface IUserService {
	
	Collection<User> getAllUsers();
	User getUser(Long id);
	User save(User User);
	Boolean delete(Long id);
	User update(Long id, User user);

}
