package com.lyne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 通过@EnableConfigServer注解启动config server
 *
 */
@EnableConfigServer
@SpringBootApplication
public class SpringCloudSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSimpleApplication.class, args);
	}
}
