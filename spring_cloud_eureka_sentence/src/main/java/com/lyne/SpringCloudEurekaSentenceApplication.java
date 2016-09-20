package com.lyne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudEurekaSentenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaSentenceApplication.class, args);
	}
}
