package com.co.labx.insumo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.labx.insumo.dto.ProductoDTO;
import com.co.labx.util.dto.ProductoResponseDTO;
import com.co.labx.util.dto.ResponseDTO;
import com.co.labx.insumo.service.IProductoService;

@RestController
@RequestMapping("/insumo")
public class InsumoRestController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ProductoResponseDTO>> listar() {
		try {
			List<ProductoResponseDTO> productos = productoService.obtenerProductos();
			return ResponseEntity.status(HttpStatus.OK).body(productos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductoResponseDTO> obener(@PathVariable("id") String id) {
		try {
			ProductoResponseDTO producto = productoService.obtenerProducto(id);
			if(producto == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			} else {
				return ResponseEntity.status(HttpStatus.OK).body(producto);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			System.out.print(e.getCause().toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<ResponseDTO<ProductoResponseDTO>> crear(@RequestHeader("id") String id, @RequestBody ProductoDTO productoDTO) {
		ResponseDTO<ProductoResponseDTO> productoResponse = new ResponseDTO<ProductoResponseDTO>();
		try {
			if(productoDTO.getIdFamilia() != null) {
				productoResponse.setSuccess(false);
				productoResponse.setMessage("El producto no tiene id familia");
				new Exception("El producto no tiene id familia");
			}
			productoDTO.setIdUsuario(id);
			productoService.guardarProducto(productoResponse, productoDTO);
			return ResponseEntity.status(HttpStatus.OK).body(productoResponse);
		} catch (Exception e) {
			if(productoResponse.getMessage() == null || productoResponse.getMessage().isEmpty()) {
				productoResponse.setMessage("Ocurrió un error, por favor intenté más tarde");
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(productoResponse);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<ResponseDTO<ProductoResponseDTO>> actualizar(@RequestHeader("id") String id, @RequestBody ProductoDTO productoDTO) {
		ResponseDTO<ProductoResponseDTO> productoResponse = new ResponseDTO<ProductoResponseDTO>();
		try {
			if(productoDTO.getIdFamilia() != null) {
				productoResponse.setSuccess(false);
				productoResponse.setMessage("El producto no tiene id familia");
				new Exception("El producto no tiene id familia");
			}
			productoDTO.setIdUsuario(id);
			productoService.guardarProducto(productoResponse, productoDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(productoResponse);
		} catch (Exception e) {
			if(productoResponse.getMessage() == null || productoResponse.getMessage().isEmpty()) {
				productoResponse.setMessage("Ocurrió un error, por favor intenté más tarde");
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(productoResponse);
		}
	}
	
}
