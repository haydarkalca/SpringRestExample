package com.restexample.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.restexample.annotations.MyJsonRestController;
import com.restexample.service.IUserService;
import com.saha.model.User;

@MyJsonRestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	@Qualifier("jpaUserService")
	// interface in iki tane implementasyonu old için bu anatasyon ile
	// vurguluyoruz.
	private IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<User> users() {
		return userService.getAllUsers();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	// param da kullanılabilir burada
	public User user(@PathVariable Long id) // burada da requestParam kullanılır
	{
		return userService.getUser(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public User update(@PathVariable Long id, @RequestBody User user) {
		if (id == 99) {
            throw new RuntimeException();
        }
		return userService.update(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Boolean delete(@PathVariable Long id) {
		return userService.delete(id);
	}

}
