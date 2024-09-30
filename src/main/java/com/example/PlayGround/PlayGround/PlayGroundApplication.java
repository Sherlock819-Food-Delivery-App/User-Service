package com.example.PlayGround.PlayGround;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PlayGroundApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PlayGroundApplication.class, args);
	}

}
