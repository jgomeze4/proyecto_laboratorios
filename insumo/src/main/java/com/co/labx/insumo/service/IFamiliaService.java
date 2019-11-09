package com.co.labx.insumo.service;

import java.util.List;

import com.co.labx.insumo.dto.FamiliaRequestDTO;
import com.co.labx.util.dto.FamiliaResponseDTO;

public interface IFamiliaService {

	List<FamiliaResponseDTO> listar();
	
	FamiliaResponseDTO findById(String idFamilia);
	
	FamiliaResponseDTO crear(FamiliaRequestDTO familiaRequestDTO);
	
}
