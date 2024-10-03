package com.example.PlayGround.PlayGround;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class UserApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(UserApplication.class, args);
	}

}