package edu.curso.java.spring.service;

import edu.curso.java.spring.bo.Producto;

public interface ProductoService {

	public Long altaDeNuevoProducto(Producto producto) throws ProductoException;
}
