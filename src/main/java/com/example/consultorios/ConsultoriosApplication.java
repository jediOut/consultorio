package com.example.consultorios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories("com.example.consultorios.dao")
@EntityScan("com.example.consultorios.entity")
@ComponentScan("com.example.consultorios")
public class ConsultoriosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultoriosApplication.class, args);
	}

}
