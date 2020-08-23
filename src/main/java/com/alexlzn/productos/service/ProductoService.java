package com.alexlzn.productos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexlzn.productos.dao.IProductoDAO;
import com.alexlzn.productos.interfaces.IProductoService;
import com.alexlzn.productos.model.Producto;
@Service
public class ProductoService implements IProductoService {

	@Autowired
	private IProductoDAO productoDao;
	
	@Override
	@Transactional(readOnly = true) //indica a Spring que es una transaccion con la base de datos (solo de lectura)
	public List<Producto> findAll() {
		//Lista de todos los productos
		return productoDao.findAll();
	}

	@Override
	public Producto findById(Long id) {
		// Buscando producto por su Id
		Optional<Producto> product = productoDao.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		
		return null;
	}

}
