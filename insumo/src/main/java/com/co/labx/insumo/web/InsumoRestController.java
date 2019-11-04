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
import com.co.labx.insumo.model.Producto;
import com.co.labx.insumo.service.IProductoService;

@RestController
@RequestMapping("/api/insumo")
public class InsumoRestController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Producto>> obtener() {
		try {
			List<Producto> productos = productoService.obtenerProductos();
			return ResponseEntity.status(HttpStatus.OK).body(productos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Producto> crear(@RequestBody ProductoDTO productoDTO) {
		try {
			if(productoDTO.getIdFamilia() != null) {
				new Exception("El producto no puede tener id");
			}
			Producto productoResponse = productoService.guardarProducto(productoDTO);
			return ResponseEntity.status(HttpStatus.OK).body(productoResponse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Producto> actualizar(@RequestBody ProductoDTO productoDTO) {
		try {
			if(productoDTO.getIdFamilia() == null) {
				new Exception("El producto no tiene id");
			}
			Producto productoResponse = productoService.guardarProducto(productoDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(productoResponse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}
