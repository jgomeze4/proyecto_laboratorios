package com.co.labx.inventario.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.labx.inventario.model.Prueba;
import com.co.labx.inventario.model.PruebaPK;
import com.co.labx.inventario.service.IPruebaService;

@RestController
@RequestMapping("/api/inventario")
public class InventarioRestController {

	@Autowired
	private IPruebaService pruebaService;
	
	@GetMapping
	public List<Prueba> obtener() {
	
		return pruebaService.obtener();
	}
	
	@GetMapping("/test")
	public String prueba() {
		return "Prueba";
	}
	
	@PostMapping
	public void guardar(@RequestBody Prueba prueba) {
	
		pruebaService.guardar(prueba);
	}
	
	@PostMapping("/find")
	public Prueba encontrar(@RequestBody PruebaPK pruebaPK) {
	
		return pruebaService.find(pruebaPK);
	}
	
}
