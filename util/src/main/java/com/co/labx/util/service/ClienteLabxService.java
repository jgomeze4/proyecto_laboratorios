package com.co.labx.util.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class ClienteLabxService<T> implements IClienteLabxService<T> {
	
	private final Class<T> tipoClase;

    public ClienteLabxService(Class<T> tipoClase) {
        this.tipoClase = tipoClase;
    }

	public T doGet(String url) throws Exception {
		HttpURLConnection con = null;
		T objectResponse = null; 
		try {
			System.out.println(url);
			con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("GET");
			System.out.println(con.getResponseCode());
			if(con.getResponseCode() == 200) {		
				StringBuilder content;
	
				try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
	
					String line;
					content = new StringBuilder();
	
					while ((line = in.readLine()) != null) {
	
						content.append(line);
						content.append(System.lineSeparator());
					}
				}
				
				objectResponse = new Gson().fromJson(content.toString(), tipoClase);
			}
		} catch (IOException e) {
			throw new Exception("Ocurrió un error al procesar la petición" + e.getMessage());
		} finally {
			con.disconnect();
		}
		return objectResponse;
	}

}
