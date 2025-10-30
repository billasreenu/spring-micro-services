package com.billa.sms.password;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.billa.sms")
public class PasswordServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordServiceApplication.class, args);
	}

}
