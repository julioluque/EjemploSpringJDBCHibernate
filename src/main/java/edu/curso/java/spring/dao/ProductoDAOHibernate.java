package edu.curso.java.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.bo.Producto;

@Repository
@Transactional
public class ProductoDAOHibernate implements ProductoDAO {

	@Autowired
	private SessionFactory sf;

	public Long altaDeProducto(Producto producto) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(producto);
		return producto.getId();
	}

	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(producto);
	}

	public Producto buscarProductoPorId(Long id) {
		// TODO Auto-generated method stub
		return (Producto) sf.getCurrentSession().load(Producto.class, id);
	}

	public void borrarProductoPorId(Long id) {
		// TODO Auto-generated method stub
		Producto producto = buscarProductoPorId(id);
		sf.getCurrentSession().delete(producto);
	}

	@SuppressWarnings("unchecked")
	public List<Producto> buscarProducto() {
		// TODO Auto-generated method stub
		Query consulta = sf.getCurrentSession().createQuery("from Producto");
		return consulta.list();
	}

}
