package com.co.labx.inventario.service;

import java.util.List;

import com.co.labx.inventario.DTO.KardexDTO;
import com.co.labx.inventario.model.Kardex;

public interface IKardexService {

	List<Kardex> listar();
	
	Kardex ingresar(KardexDTO kardexDTO) throws Exception;
	
}
