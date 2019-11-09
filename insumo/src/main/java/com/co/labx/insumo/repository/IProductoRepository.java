package com.co.labx.insumo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.labx.insumo.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, String> {

	@Query(value="SELECT * FROM productos WHERE nombre = :nombre and marca = :marca and proveedor = :proveedor", nativeQuery=true)
	Producto findByValueUnique(@Param("nombre") String nombre, @Param("marca") String marca, @Param("proveedor") String proveedor);
	
}
