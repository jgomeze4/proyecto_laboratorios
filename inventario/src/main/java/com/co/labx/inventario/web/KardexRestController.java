package com.co.labx.inventario.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.labx.inventario.DTO.KardexDTO;
import com.co.labx.inventario.model.Kardex;
import com.co.labx.inventario.service.IKardexService;

@RestController
@RequestMapping("/inventario")
public class KardexRestController {

	@Autowired
	private IKardexService kardexService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Kardex>> obtener() {
		try {
			List<Kardex> kardex =kardexService.listar();
			return ResponseEntity.status(HttpStatus.OK).body(kardex);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/ingresar")
	public ResponseEntity<Kardex> ingresar(@RequestBody KardexDTO kardexDTO) {
		try {
			Kardex kardex = kardexService.ingresar(kardexDTO);
			return ResponseEntity.status(HttpStatus.OK).body(kardex);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}
