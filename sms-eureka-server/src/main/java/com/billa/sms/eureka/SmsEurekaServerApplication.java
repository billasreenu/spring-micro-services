package com.billa.sms.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SmsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsEurekaServerApplication.class, args);
	}

}
