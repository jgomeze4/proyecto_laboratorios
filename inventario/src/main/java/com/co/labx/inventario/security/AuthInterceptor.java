package com.co.labx.inventario.security;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerInterceptor;

import com.co.labx.util.service.ClienteLabxService;

public class AuthInterceptor implements HandlerInterceptor {

	private ClienteLabxService<String> clienteSecurityLabx;
	
	@Autowired
	private Environment env;
	
	public AuthInterceptor() {
		clienteSecurityLabx = new ClienteLabxService<>(String.class);
	}
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {		 
		String token = req.getHeader("Authorization");
		if(token.startsWith("Bearer ")) {
			Map<String, String> value = new HashMap<String, String>();
			value.put("email", req.getHeader("user"));
			value.put("token", token.replace("Bearer ", ""));
			
			String url = String.format("%s%s%s", env.getProperty("labx.security.host"),
					env.getProperty("labx.security.path"));
			String responseValidation = clienteSecurityLabx.doPost(url, value, 200);
			if(responseValidation != null && responseValidation.equals(token.replace("Bearer ", ""))) {
				return true;
			}
		}
		res.setStatus(401);
		return false;
	}

}
