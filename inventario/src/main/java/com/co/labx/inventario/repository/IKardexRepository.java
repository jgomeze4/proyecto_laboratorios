package com.co.labx.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.co.labx.inventario.model.Kardex;
import com.co.labx.inventario.model.KardexPK;

public interface IKardexRepository extends JpaRepository<Kardex, KardexPK> {

	@Query(value="SELECT * FROM kardex where now() > fecha_vencimiento and activo = 'A'", nativeQuery = true)
	List<Kardex> findByKardexVencimiento();
	
}
