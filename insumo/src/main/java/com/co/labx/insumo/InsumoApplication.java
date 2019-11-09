package com.co.labx.insumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.co.labx.insumo.security.AuthInterceptor;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableWebMvc
public class InsumoApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(InsumoApplication.class, args);
	}

	@Bean
	public AuthInterceptor authInterceptor() {
	    return new AuthInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor()).addPathPatterns("/**");
	}

}
