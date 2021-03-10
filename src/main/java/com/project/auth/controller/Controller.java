package com.project.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@GetMapping("/test")
	public String test() {
		return "Test";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
