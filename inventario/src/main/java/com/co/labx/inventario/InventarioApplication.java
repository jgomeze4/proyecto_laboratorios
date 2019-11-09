package com.co.labx.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.co.labx.inventario.security.AuthInterceptor;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableWebMvc
public class InventarioApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
	}

}
