package com.restexample.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
//import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.restexample.annotations.TestProfile;
import com.restexample.persistence.entity.UserEntity;
import com.restexample.persistence.repository.UserRepository;
import com.saha.model.User;

@Service
@TestProfile
public class JpaUserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DozerBeanMapper mapper;

	//@Cacheable(value = "allUsers", unless = "#result.size() > 10")
	public Collection<User> getAllUsers() {
		Iterable<UserEntity> userEntities = userRepository.findAll();
		// Iterable<UserEntity> userEntities = userRepository.findAll(new
		// PageRequest(page, size));
		List<User> users = new ArrayList<User>();
		for (UserEntity userEntity : userEntities) {
			User user = new User();
			mapper.map(userEntity, user);
			users.add(user);
		}
		return users;

	}

	// public User

	@Cacheable(value = "users", condition = "#id > 20")
	public User getUser(Long id) {
		UserEntity userEntity = userRepository.findOne(id);
		User getUserbyId = new User();
		mapper.map(userEntity, getUserbyId);
		return getUserbyId;
	}

	public User save(User user) {
		UserEntity userEntity = new UserEntity();
		mapper.map(user, userEntity);// source dan locationa gibi düşünlebilir.
		// userEntity.setUserName(user.getUserName());
		userEntity = userRepository.save(userEntity);

		User savedUser = new User();
		// savedUser.setUserName(userEntity.getUserName());
		// savedUser.setTcKimlik(userEntity.getId().toString());
		mapper.map(userEntity, savedUser);
		return savedUser;
	}

	@CacheEvict(value = "{users,allUsers}", allEntries = true, condition = "#result")
	public Boolean delete(Long id) {
		userRepository.delete(id);
		return true;
	}

	@CacheEvict(value="allUsers")
	@CachePut(value="users",key="#id")
	public User update(Long id, User user) {
		UserEntity userEntity = userRepository.findOne(id);
		User updatedUser = new User();
		mapper.map(userEntity, updatedUser);
		updatedUser.setLastName(user.getLastName());
		updatedUser.setName(user.getName());
		updatedUser.setUserName(user.getUserName());
		mapper.map(updatedUser, userEntity);
		userEntity = userRepository.save(userEntity);
		return updatedUser;

	}
}
