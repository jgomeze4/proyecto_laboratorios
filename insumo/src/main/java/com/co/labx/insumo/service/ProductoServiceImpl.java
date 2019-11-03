package com.co.labx.insumo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.labx.insumo.model.Producto;
import com.co.labx.insumo.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public List<Producto> obtenerProductos() {
		return productoRepository.findAll();
	}
	
	
	
}
