package com.co.labx.util.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ClienteLabxService<T> implements IClienteLabxService<T> {
	
	private final Class<T> tipoClase;

    public ClienteLabxService(Class<T> tipoClase) {
        this.tipoClase = tipoClase;
    }

	public T doGet(String url, int codeSucess, Map<String, String> headers) throws Exception {
		HttpURLConnection con = null;
		T objectResponse = null; 
		try {
			System.out.println(url);
			con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			if(headers != null) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
			        con.setRequestProperty(header.getKey(), header.getValue());
				}
			}
			
			if(con.getResponseCode() == codeSucess) {		
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
			if(con != null) {
				con.disconnect();
			}
		}
		return objectResponse;
	}
	
	public T doPost(String url, Map<String, String> params, int codeSucess, Map<String, String> headers) throws Exception {
		HttpURLConnection con = null;
		T objectResponse = null; 
		try {
			con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			if(headers != null) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
			        con.setRequestProperty(header.getKey(), header.getValue());
				}
			}
			con.setDoInput(true);
			con.setDoOutput(true);
			
			JsonObject values = new JsonObject();
			
			for (Map.Entry<String, String> entry : params.entrySet()) {
		        values.addProperty(entry.getKey(), entry.getValue());
			}
			
			OutputStream os = con.getOutputStream();
			BufferedWriter writer = new BufferedWriter(
			        new OutputStreamWriter(os, "UTF-8"));
			System.out.println(values.toString());
			writer.write(values.toString());
			writer.flush();
			writer.close();
			os.close();
			
			if(con.getResponseCode() == codeSucess) {		
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
			throw new Exception("Ocurrio un error al procesar la peticion " + e.getMessage());
		} finally {
			con.disconnect();
		}
		return objectResponse;
	}

}
