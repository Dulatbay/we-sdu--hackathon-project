package com.example.usersbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UsersBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersBackendApplication.class, args);
	}

}
