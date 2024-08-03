package com.triptogether.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {
		"com.triptogether.api.auth.repository",
		"com.triptogether.api.user.repository"
})
public class TripTogetherApiServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripTogetherApiServicesApplication.class, args);
	}

}
