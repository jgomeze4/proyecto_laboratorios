package com.co.labx.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.labx.inventario.model.Prueba;
import com.co.labx.inventario.model.PruebaPK;

public interface IPruebaRepository extends JpaRepository<Prueba, PruebaPK> {

}
