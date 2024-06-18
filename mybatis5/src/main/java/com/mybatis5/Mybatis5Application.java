package com.mybatis5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mybatis5Application {

	public static void main(String [] args) {
		SpringApplication.run(Mybatis5Application.class,
				"--spring.config.location-classpath:application-test.properties");
	}

}
