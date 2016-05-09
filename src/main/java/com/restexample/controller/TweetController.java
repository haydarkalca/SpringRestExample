package com.restexample.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.restexample.annotations.MyJsonRestController;
import com.restexample.persistence.entity.TweetEntity;
import com.restexample.service.TweetService;
import com.saha.model.Tweet;
import com.saha.model.User;

@MyJsonRestController
@RequestMapping(value = "/users/{id}/tweets")
public class TweetController {

	@Autowired
	private TweetService tweetService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public List<Tweet> create(@RequestBody TweetEntity tweet,
			@PathVariable(value = "id") Long userId) {
		return tweetService.save(tweet, userId);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Tweet> userTweets(@PathVariable("id") Long userId) {
		return tweetService.userTweets(userId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public User user(@PathVariable Long id) {
		// return tweetService.users(id);
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public User update(@RequestBody User user, @PathVariable Long id) {
		return null;
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		tweetService.delete(id);
	}
}
