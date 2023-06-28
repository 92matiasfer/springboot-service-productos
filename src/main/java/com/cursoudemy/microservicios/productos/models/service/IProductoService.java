package com.cursoudemy.microservicios.productos.models.service;

import java.util.List;

import com.cursoudemy.microservicios.productos.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id);
	
}