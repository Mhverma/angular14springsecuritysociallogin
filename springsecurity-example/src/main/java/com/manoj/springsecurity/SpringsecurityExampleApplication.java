package com.manoj.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringsecurityExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityExampleApplication.class, args);
	}

}
