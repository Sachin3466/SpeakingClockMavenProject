package com.example.SpeakingClockMavenProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.demo.*")
public class SpeakingClockMavenProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeakingClockMavenProjectApplication.class, args);
	}

}
