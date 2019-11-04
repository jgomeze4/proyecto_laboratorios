package com.co.labx.insumo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.labx.insumo.model.Familia;
import com.co.labx.insumo.repository.IFamiliaRepository;

@Service
public class FamiliaServiceImpl implements IFamiliaService {

	@Autowired
	private IFamiliaRepository familiaRepository;

	public List<Familia> listar() {
		return familiaRepository.findAll().stream().filter(x -> x.getActivo().equals("A")).collect(Collectors.toList());
	}

	@Override
	public Familia findById(Long idFamilia) {
		Optional<Familia> familia = familiaRepository.findById(idFamilia);
		return familia.isPresent() ? familia.get() : null;
	}

}
