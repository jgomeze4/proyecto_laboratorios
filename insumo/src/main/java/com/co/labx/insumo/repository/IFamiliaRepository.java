package com.co.labx.insumo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.labx.insumo.model.Familia;

@Repository
public interface IFamiliaRepository extends JpaRepository<Familia, String> {

}
