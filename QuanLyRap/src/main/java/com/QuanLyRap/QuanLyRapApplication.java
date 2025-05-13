package com.QuanLyRap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class QuanLyRapApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuanLyRapApplication.class, args);
	}

}
