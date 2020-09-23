package com.api.mvo.core.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Prueba {
	
	@GetMapping("/")
	public String prueba() {
		return "WELCOME";
	}

}
