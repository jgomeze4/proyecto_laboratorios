package com.co.labx.insumo.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/insumo")
public class InsumoRestController {

	@GetMapping
	public String obtener() {
	
		return "Hola";
	}
	
}
