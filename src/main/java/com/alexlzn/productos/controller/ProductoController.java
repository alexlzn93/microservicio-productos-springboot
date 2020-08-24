package com.alexlzn.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexlzn.productos.interfaces.IProductoService;
import com.alexlzn.productos.model.Producto;

@RestController
public class ProductoController {
	
	@Autowired
	IProductoService productservice;
	@Autowired
	private Environment enviroment;
	
	@Value("${server.port}") //value para inyectar a Spring valores que definamos en el application.properties
	private Integer port;
	
	@GetMapping("/listProductos")
	public List<Producto> getListProducto(){
		return productservice.findAll().stream().map(producto-> {
			//producto.setPort(Integer.parseInt(enviroment.getProperty("local.server.port")));
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/productoID/{id}")
	public Producto findByIdProducto(@PathVariable("id") Long id) {
		System.out.println("Producto con id " +id);
		Producto producto= productservice.findById(id);
		 //se pone local y el nombre de la variable definida en el application.properties (server.port)
		//producto.setPort(Integer.parseInt(enviroment.getProperty("local.server.port")));
		producto.setPort(port);
		return producto;
	}
	@PostMapping("/nuevoProducto")
	public Producto nuevoProducto(@RequestBody Producto producto ) {
		productservice.guardarProducto(producto);
		return producto;
	}

}
