package com.esprit.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DevopsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevopsProjectApplication.class, args);
	}

}
