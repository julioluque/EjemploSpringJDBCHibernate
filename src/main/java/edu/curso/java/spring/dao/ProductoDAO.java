package edu.curso.java.spring.dao;

import java.util.List;

import edu.curso.java.spring.bo.Producto;

public interface ProductoDAO {

	public Long altaDeProducto(Producto producto);

	public void actaulizarProducto(Producto producto);

	public Producto buscarProductoPorId(Long id);

	public void borrarProductoPorId(Long id);

	public List<Producto> buscarProducto();

}
