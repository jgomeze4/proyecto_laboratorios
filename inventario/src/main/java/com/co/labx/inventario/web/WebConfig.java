package com.co.labx.inventario.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.co.labx.util.service.ClienteLabxService;

@Configuration
@EnableWebMvc
public class WebConfig implements Filter, WebMvcConfigurer {
	
	private ClienteLabxService<String> clienteSecurityLabx;

	@Autowired
	private Environment env;
	
	public WebConfig() {
		clienteSecurityLabx = new ClienteLabxService<>(String.class);
	}
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		System.out.println("WebConfig; " + request.getRequestURI());
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,id");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Expose-Headers", "Authorization");
		response.addHeader("Access-Control-Expose-Headers", "responseType");
		response.addHeader("Access-Control-Expose-Headers", "id");
		System.out.println("Request Method: " + request.getMethod());

		if (!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {
			if(!validate(request)) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			} else {
				try {
					chain.doFilter(req, res);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Pre-flight");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "Access-Control-Expose-Headers"
					+ "Authorization, content-type,"
					+ "id,access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with,responseType");
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}

	private boolean validate(HttpServletRequest req) {
		String token = req.getHeader("Authorization");
		String id = req.getHeader("id");
		if (token != null && token.startsWith("Bearer ") && id != null && !id.isEmpty()) {
			Map<String, String> value = new HashMap<String, String>();
			value.put("id", id);
			value.put("token", token.replace("Bearer ", ""));

			String url = String.format("%s%s", env.getProperty("labx.security.host"),
					env.getProperty("labx.security.path"));
			String responseValidation;
			try {
				responseValidation = clienteSecurityLabx.doPost(url, value, 200, null);
				if (responseValidation != null && responseValidation.equals(token.replace("Bearer ", ""))) {
					return true;
				}
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}
	
}
