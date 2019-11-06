package com.co.labx.security_manager.helper;

import java.util.Base64;

import org.apache.commons.codec.digest.DigestUtils;

public class CifrarHelper {

	public static String valorASHA256(String valor) {
		return DigestUtils.sha256Hex(valor);
	}
	
	public static String Base64AString(String valor) {
		return new String(Base64.getDecoder().decode(valor));
	}
	
	public static String StringABase64(String valor) {
		return Base64.getEncoder().encodeToString(valor.getBytes());
	}
	
}
