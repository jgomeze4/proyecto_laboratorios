package com.co.labx.inventario.service;

import java.util.List;
import java.util.Optional;

import com.co.labx.inventario.model.Prueba;
import com.co.labx.inventario.model.PruebaPK;

public interface IPruebaService {

	List<Prueba> obtener();
	void guardar(Prueba prueba);
	Prueba find(PruebaPK pruebaPK);
	
}
