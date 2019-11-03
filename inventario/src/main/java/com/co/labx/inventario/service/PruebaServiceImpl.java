package com.co.labx.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.labx.inventario.model.Prueba;
import com.co.labx.inventario.model.PruebaPK;
import com.co.labx.inventario.repository.IPruebaRepository;

@Service
public class PruebaServiceImpl implements IPruebaService {

	@Autowired
	private IPruebaRepository pruebaRepo;
	
	@Override
	public List<Prueba> obtener() {
		return pruebaRepo.findAll();
	}

	@Override
	public void guardar(Prueba prueba) {
		pruebaRepo.save(prueba);
	}

	@Override
	public Prueba find(PruebaPK pruebaPK) {
		Optional<Prueba> prueba = pruebaRepo.findById(pruebaPK);
		
		return prueba.isPresent() ? prueba.get() : null;		
	}

}
