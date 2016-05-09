package com.restexample.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.restexample.annotations.MyJsonRestController;
import com.restexample.service.TweetService;
import com.saha.model.Tweet;

@MyJsonRestController
@RequestMapping(value = "/tweets")
public class TimeLineController {

	@Autowired
	private TweetService tweetService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Tweet> tweets(
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size) {
		return tweetService.tweets(page, size);
	}

}
