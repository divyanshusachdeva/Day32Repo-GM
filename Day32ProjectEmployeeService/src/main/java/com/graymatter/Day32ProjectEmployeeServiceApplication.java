package com.graymatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Day32ProjectEmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day32ProjectEmployeeServiceApplication.class, args);
	}

}
