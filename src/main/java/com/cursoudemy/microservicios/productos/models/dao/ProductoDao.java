package com.cursoudemy.microservicios.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.cursoudemy.microservicios.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

	
}
