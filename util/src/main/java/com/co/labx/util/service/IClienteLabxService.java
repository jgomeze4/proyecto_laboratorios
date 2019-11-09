package com.co.labx.util.service;

import java.util.Map;

public interface IClienteLabxService<T> {

	T doGet(String url, int codeSucess, Map<String, String> headers) throws Exception;
	T doPost(String url, Map<String, String> params, int codeSucess, Map<String, String> headers) throws Exception;
	
}
