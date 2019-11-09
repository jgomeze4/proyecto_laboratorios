package com.co.labx.insumo.helper;

import com.co.labx.util.dto.FamiliaResponseDTO;
import com.co.labx.insumo.model.Familia;

public class FamiliaHelper {
	
	public static FamiliaResponseDTO familiaAFamiliaResponseDTO(Familia familia) {
		
		if(familia == null) {
			return null;
		}
		
		FamiliaResponseDTO familiaResponseDTO = new FamiliaResponseDTO();
		
		familiaResponseDTO.setId(familia.getIdFamilia());
		familiaResponseDTO.setNombre(familia.getNombre());
		
		return familiaResponseDTO;
	}

}
