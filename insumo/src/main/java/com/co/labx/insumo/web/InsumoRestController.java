package com.co.labx.insumo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.labx.insumo.model.Producto;
import com.co.labx.insumo.service.IProductoService;

@RestController
@RequestMapping("/api/insumo")
public class InsumoRestController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> obtener() {
		return productoService.obtenerProductos();
	}
	
}
