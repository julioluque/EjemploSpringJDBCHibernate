package edu.curso.java.spring;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.bo.Producto;
import edu.curso.java.spring.dao.ProductoDAO;
import edu.curso.java.spring.service.ProductoException;
import edu.curso.java.spring.service.ProductoService;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		EJEMPLO 1 ======================================================================
		ProductoDAO productoDAO = context.getBean(ProductoDAO.class);
		Producto prodDao = new Producto();
		prodDao.setNombre("TV LCD");
		prodDao.setPrecio(1000.00);
		
		productoDAO.altaDeProducto(prodDao);
		
//		EJEMPLO 2 ======================================================================
		ProductoService productoService = context.getBean(ProductoService.class);
		Producto p1 = new Producto();
		p1.setNombre("TV Smart");
		p1.setPrecio(5000.00);
		
		try {
			productoService.altaDeNuevoProducto(p1);
		} catch (ProductoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Producto p2 = new Producto();
		p2.setNombre("TV Old");
		p2.setPrecio(0.00);
		
		try {
			productoService.altaDeNuevoProducto(p2);
		} catch (ProductoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		EJEMPLO 3 ======================================================================

	}

}
