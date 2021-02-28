package com.kanish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.kanish.entity.Contact;
import com.kanish.service.ContactService;

@SpringBootApplication
public class MiniProjectPhoneContactAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MiniProjectPhoneContactAppApplication.class, args);
	
		
	
	}

}
