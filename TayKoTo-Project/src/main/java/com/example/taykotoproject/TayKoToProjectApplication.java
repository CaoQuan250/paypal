package com.example.taykotoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TayKoToProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TayKoToProjectApplication.class, args);
	}

}
