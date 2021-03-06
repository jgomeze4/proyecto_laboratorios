package com.co.labx.inventario.service;

import java.util.List;
import java.util.Map;

import com.co.labx.inventario.DTO.KardexDTO;
import com.co.labx.util.dto.KardexResponseDTO;
import com.co.labx.util.dto.ResponseDTO;

public interface IKardexService {

	List<KardexResponseDTO> listar(Map<String, String> headers) throws Exception;
	
	void ingresar(ResponseDTO<KardexResponseDTO> response, KardexDTO kardexDTO, Map<String, String> headers) throws Exception;
	
	void salida(ResponseDTO<KardexResponseDTO> response, KardexDTO kardexDTO, Map<String, String> headers) throws Exception;
	
	void validarKardexVencido();
	
}
