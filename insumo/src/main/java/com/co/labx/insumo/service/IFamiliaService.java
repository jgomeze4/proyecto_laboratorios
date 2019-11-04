package com.co.labx.insumo.service;

import java.util.List;

import com.co.labx.insumo.model.Familia;

public interface IFamiliaService {

	List<Familia> listar();
	
	Familia findById(Long idFamilia);
	
}
