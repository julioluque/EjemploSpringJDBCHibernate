package edu.curso.java.spring;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.bo.Producto;
import edu.curso.java.spring.dao.ProductoDAO;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProductoDAO productoDAO = context.getBean(ProductoDAO.class);
		Producto producto = new Producto();
		producto.setNombre("TV LCD");
		producto.setPrecio(1000.00);
		
		productoDAO.altaDeProducto(producto);
		
	}

}
