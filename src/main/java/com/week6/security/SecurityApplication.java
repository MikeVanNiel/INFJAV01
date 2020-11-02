package com.week6.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class SecurityApplication {

	/*@Bean
	UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.withDefaultPasswordEncoder()
					.username("mike")
					.password(("mike"))
					.roles("USER")
					.build()
		);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

}
