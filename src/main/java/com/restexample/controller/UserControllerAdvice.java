package com.restexample.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.restexample.annotations.MyJsonRestController;
import com.saha.model.MyError;

//@ControllerAdvice(basePackages="com.restexample.controller")//bu advice nerelerde geçerli olmasını istiyorsak ona göre path veriyoruz.
@ControllerAdvice(annotations = MyJsonRestController.class)
// bu annotationı kullananlarda gecerli olsun
public class UserControllerAdvice {

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public MyError handler() {
		MyError myError = new MyError();
		myError.setCode(22L);
		myError.setDescription("Record already exist");
		return myError;
	}

	@ExceptionHandler(value = RuntimeException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	public MyError allHandler(Exception ex) {
		String message = "haydar";//ex.getCause().getMessage();
		MyError myError = new MyError();
		myError.setCode(99L);
		myError.setDescription("Unexpected error " + message);
		return myError;
	}
}
