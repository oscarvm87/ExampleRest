package com.rest.codmind.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Status {

	@GetMapping(value="status")
	public String activo() {
		return "Ready";
	}
}
