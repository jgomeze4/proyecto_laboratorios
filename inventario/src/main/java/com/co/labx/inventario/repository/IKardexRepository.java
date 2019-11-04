package com.co.labx.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.labx.inventario.model.Kardex;
import com.co.labx.inventario.model.KardexPK;

public interface IKardexRepository extends JpaRepository<Kardex, KardexPK> {

}
