package com.co.labx.util.service;

import java.util.Map;

public interface IClienteLabxService<T> {

	T doGet(String url, int codeSucess) throws Exception;
	T doPost(String url, Map<String, String> params, int codeSucess) throws Exception;
	
}
