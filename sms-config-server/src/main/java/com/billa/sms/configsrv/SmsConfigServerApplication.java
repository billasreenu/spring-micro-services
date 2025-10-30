package com.billa.sms.configsrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SmsConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsConfigServerApplication.class, args);
	}

}
