package com.co.labx.util.service;

public interface IClienteLabxService<T> {

	T doGet(String url) throws Exception;
	
}
