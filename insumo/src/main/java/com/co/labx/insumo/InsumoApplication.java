package com.co.labx.insumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class InsumoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsumoApplication.class, args);
	}

}
