package com.co.labx.util.service;

import java.util.Map;
import java.util.Optional;

public interface IClienteLabxService<T> {

	T doGet(String url, int codeSucess, Map<String, String> headers) throws Exception;
	T doPost(String url, Map<String, String> params, int codeSucess, Optional<Map<String, String>> headers) throws Exception;
	
}
