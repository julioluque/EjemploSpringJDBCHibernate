package edu.curso.java.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.bo.Producto;
import edu.curso.java.spring.dao.ProductoDAO;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDAO productoDAO;

	public Long altaDeNuevoProducto(Producto producto) throws ProductoException {
		// TODO Auto-generated method stub
		if (producto.getPrecio() < 0.0)
			throw new  ProductoException("El producto tiene qeu tener precio > 0");
		return productoDAO.altaDeProducto(producto);
	}

}
