package com.alexlzn.productos.interfaces;

import java.util.List;

import com.alexlzn.productos.model.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id);
}
