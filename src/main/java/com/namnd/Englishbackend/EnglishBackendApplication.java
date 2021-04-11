package com.namnd.Englishbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EnglishBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnglishBackendApplication.class, args);
	}

}
