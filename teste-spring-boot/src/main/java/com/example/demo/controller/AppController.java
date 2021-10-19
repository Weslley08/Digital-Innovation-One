package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class AppController {

	@Value("${app.message}")
	private String appMessage;

	@Value("${ENV_DB_URL:NENHUMA}")
	private String dbEnvironmentVariable;

	@GetMapping("/")
	public String appMessage() {
		return appMessage;
	}

	@GetMapping("/enviVariable")
	public String getDbEnvironmentVariable() {
		return "A url passada foi: " + dbEnvironmentVariable;
	}
}