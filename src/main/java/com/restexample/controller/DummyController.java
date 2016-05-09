package com.restexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restexample.persistence.entity.DummyEntity;
import com.restexample.service.DummyService;

@RestController
@RequestMapping(value = "/dummies")
public class DummyController {

	@Autowired
	private DummyService dummyService;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<DummyEntity> users() {
		return dummyService.dummies();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public DummyEntity create(@RequestBody DummyEntity dummy) {
		return dummyService.save(dummy);
		
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public DummyEntity create(@RequestBody DummyEntity dummy,
			@PathVariable Long id) {
		return dummyService.update(dummy, id);
	}
}
