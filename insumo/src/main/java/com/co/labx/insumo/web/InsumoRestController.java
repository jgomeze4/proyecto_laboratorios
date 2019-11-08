package com.co.labx.insumo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.labx.insumo.dto.ProductoDTO;
import com.co.labx.insumo.dto.ProductoResponseDTO;
import com.co.labx.insumo.service.IProductoService;

@RestController
@RequestMapping("/insumo")
public class InsumoRestController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ProductoResponseDTO>> obtener() {
		try {
			List<ProductoResponseDTO> productos = productoService.obtenerProductos();
			return ResponseEntity.status(HttpStatus.OK).body(productos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<ProductoResponseDTO> crear(@RequestBody ProductoDTO productoDTO) {
		try {
			if(productoDTO.getIdFamilia() != null) {
				new Exception("El producto no puede tener id");
			}
			ProductoResponseDTO productoResponse = productoService.guardarProducto(productoDTO);
			return ResponseEntity.status(HttpStatus.OK).body(productoResponse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<ProductoResponseDTO> actualizar(@RequestBody ProductoDTO productoDTO) {
		try {
			if(productoDTO.getIdFamilia() == null) {
				new Exception("El producto no tiene id");
			}
			ProductoResponseDTO productoResponse = productoService.guardarProducto(productoDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(productoResponse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}
