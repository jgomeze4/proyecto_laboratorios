package com.co.labx.security_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.co.labx.security_manager.security.AuthInterceptor;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableWebMvc
public class SecurityManagerApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SecurityManagerApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor()).addPathPatterns(new String[] { "/api/usuario", "api/usuario/**" });
	}
	
}
