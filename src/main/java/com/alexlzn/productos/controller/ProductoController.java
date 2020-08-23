package com.alexlzn.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alexlzn.productos.interfaces.IProductoService;
import com.alexlzn.productos.model.Producto;

@RestController
public class ProductoController {
	
	@Autowired
	IProductoService productservice;
	
	
	@GetMapping("/listProducto")
	public List<Producto> getListProducto(){
		return productservice.findAll();
	}
	
	@GetMapping("/productoID/{id}")
	public Producto findByIdProducto(@PathVariable("id") Long id) {
		System.out.println("Producto con id " +id);
		return productservice.findById(id);
	}

}
