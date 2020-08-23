package com.alexlzn.productos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexlzn.productos.model.Producto;
@Repository
public interface IProductoDAO extends JpaRepository<Producto, Long> {

}
