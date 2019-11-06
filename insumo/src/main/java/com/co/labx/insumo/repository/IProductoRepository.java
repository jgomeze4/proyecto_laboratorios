package com.co.labx.insumo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.labx.insumo.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, String> {

}
