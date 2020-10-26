package com.hr.eenvijfdrielagen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EenVijfDrieLagenApplication {

	public static void main(String[] args) {
		SpringApplication.run(EenVijfDrieLagenApplication.class, args);
	}

}
