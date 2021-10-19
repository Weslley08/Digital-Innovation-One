package com.example.demo.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Getter;
import lombok.Setter;

// Configuração do banco de dados
@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DbConfiguration {
	
	private String driveClassName;
	private String url;
	@SuppressWarnings("unused")
	private String username;
	@SuppressWarnings("unused")
	private String password;
	
	
	// Método profile de desenvolvimento
	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		
		System.out.println("DB connection for dev - H2");
		System.out.println(driveClassName);
		System.out.println(url);
		return "DB connection for dev - H2";
	}
	
	// Método profile de produção
	@Profile("prod")
	@Bean
	public String prodDatabaseConnection() {
		
		System.out.println("DB connection for prod - MySQL");
		System.out.println(driveClassName);
		System.out.println(url);
		return "DB connection for prod - MySQL";
	}
	
}
