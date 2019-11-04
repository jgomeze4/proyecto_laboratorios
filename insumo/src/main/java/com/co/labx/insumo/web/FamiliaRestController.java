package com.co.labx.insumo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.labx.insumo.model.Familia;
import com.co.labx.insumo.service.IFamiliaService;

@RestController
@RequestMapping("/api/familia")
public class FamiliaRestController {

	@Autowired
	private IFamiliaService familiaService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Familia>> listar() {
		try {
			List<Familia> familiaResponse = familiaService.listar();
			return ResponseEntity.status(HttpStatus.OK).body(familiaResponse);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}
