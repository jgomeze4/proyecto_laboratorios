package com.co.labx.insumo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.labx.insumo.dto.FamiliaRequestDTO;
import com.co.labx.insumo.dto.FamiliaResponseDTO;
import com.co.labx.insumo.service.IFamiliaService;

@RestController
@RequestMapping("/familia")
public class FamiliaRestController {

	@Autowired
	private IFamiliaService familiaService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<FamiliaResponseDTO>> listar() {
		try {
			List<FamiliaResponseDTO> familiaResponse = familiaService.listar();
			return ResponseEntity.status(HttpStatus.OK).body(familiaResponse);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<FamiliaResponseDTO> crear(@RequestBody FamiliaRequestDTO familiaRequestDTO) {
		try {
			FamiliaResponseDTO familiaResponseDTO = familiaService.crear(familiaRequestDTO);
			return ResponseEntity.status(HttpStatus.OK).body(familiaResponseDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
