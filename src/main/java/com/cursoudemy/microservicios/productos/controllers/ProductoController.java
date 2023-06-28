package com.cursoudemy.microservicios.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.microservicios.productos.models.entity.Producto;
import com.cursoudemy.microservicios.productos.models.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	/*
	 * Mediante esta variable podemos obtener cualquier configuracion de nuestro achivo de configuracion
	 * En este caso lo utilizamos para obtener el puerto (server.port)
	 */
	private Environment environment;
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll().stream().map(producto ->{
			producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		/*
		 * Le asigno a cada producto el puerto de la instancia desde donde se obtuvo
		 */
		producto.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return productoService.findById(id);
	}
	
}
