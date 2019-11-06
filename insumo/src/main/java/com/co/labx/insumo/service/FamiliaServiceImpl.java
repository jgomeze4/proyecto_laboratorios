package com.co.labx.insumo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.labx.insumo.constants.FamiliaConstants;
import com.co.labx.insumo.dto.FamiliaRequestDTO;
import com.co.labx.insumo.dto.FamiliaResponseDTO;
import com.co.labx.insumo.helper.FamiliaHelper;
import com.co.labx.insumo.model.Familia;
import com.co.labx.insumo.repository.IFamiliaRepository;

@Service
public class FamiliaServiceImpl implements IFamiliaService {

	@Autowired
	private IFamiliaRepository familiaRepository;

	public List<FamiliaResponseDTO> listar() {
		List<FamiliaResponseDTO> familiaResponse = new ArrayList<FamiliaResponseDTO>();
		familiaRepository.findAll().stream().filter(x -> x.getActivo().equals(FamiliaConstants.ESTADO_ACTIVO)).forEach(fam -> {
			familiaResponse.add(FamiliaHelper.familiaAFamiliaResponseDTO(fam));
		});
		
		return familiaResponse;
	}

	@Override
	public FamiliaResponseDTO findById(String idFamilia) {
		Optional<Familia> familia = familiaRepository.findById(idFamilia);
		
		FamiliaResponseDTO familiaResponseDTO = null;
		
		if(familia.isPresent()) {
			familiaResponseDTO = FamiliaHelper.familiaAFamiliaResponseDTO(familia.get());	
		}
		
		return familiaResponseDTO;
	}

	@Override
	public FamiliaResponseDTO crear(FamiliaRequestDTO familiaRequestDTO) {
		Familia familia = new Familia();
		
		familia.setIdFamilia(UUID.randomUUID().toString());
		familia.setNombre(familiaRequestDTO.getNombre());
		familia.setIdUsuario(familiaRequestDTO.getIdUsuario());
		familia.setActivo(FamiliaConstants.ESTADO_ACTIVO);
		
		familiaRepository.save(familia);
		
		FamiliaResponseDTO familiaResponseDTO = new FamiliaResponseDTO();
		
		familiaResponseDTO.setId(familia.getIdFamilia());
		familiaResponseDTO.setNombre(familiaRequestDTO.getNombre());
		
		return familiaResponseDTO;
	}

}
