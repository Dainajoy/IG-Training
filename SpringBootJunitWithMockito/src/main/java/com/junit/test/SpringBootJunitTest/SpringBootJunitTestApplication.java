package com.junit.test.SpringBootJunitTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class })

public class SpringBootJunitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJunitTestApplication.class, args);
	}

}
