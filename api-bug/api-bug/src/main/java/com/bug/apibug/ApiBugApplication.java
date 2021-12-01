package com.bug.apibug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.jms.annotation.EnableJms;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJms
@EnableSwagger2
@EnableEurekaClient
public class ApiBugApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBugApplication.class, args);
	}

}
