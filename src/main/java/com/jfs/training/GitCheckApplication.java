package com.jfs.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitCheckApplication.class, args);
		

		System.out.println("Spring boot application running");

		
		System.out.println("hello from different branch");
	}

}
