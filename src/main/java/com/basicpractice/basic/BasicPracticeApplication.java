package com.basicpractice.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicPracticeApplication implements CommandLineRunner {

	@Autowired(required = true)
	DB db;

	public static void main(String[] args) {
		SpringApplication.run(BasicPracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(db.getDB());
	}
}
