package com.restexample.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.saha.model.User;

import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements IUserService {
	
	private static final Map<Long,User> users = new HashMap<Long, User>();
	
	public Collection<User> getAllUsers(){
		return users.values();
	}
	
	public User getUser(Long id)
	{
		return users.get(id);
	}
		
	public User save (User user)
	{
		Long id = users.size() + 1l;
		user.setTcKimlik(id.toString());
		users.put(id, user);
		return users.get(id);
	}
	
	public Boolean delete (Long id)
	{
		return users.remove(id) != null;
	}
	
	public User update (Long id ,User user)
	{
		User currentUser = users.get(id);
		currentUser.setName(user.getName());
		currentUser.setLastName(user.getLastName());
		currentUser.setUserName(user.getUserName());
		
		return currentUser;
	}
	
}
