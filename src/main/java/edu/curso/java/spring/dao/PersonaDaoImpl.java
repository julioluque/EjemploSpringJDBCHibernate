package edu.curso.java.spring.dao;

import java.sql.*;
import java.util.*;

import javax.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.curso.java.spring.bo.Persona;

public class PersonaDaoImpl implements PersonaDAO {

	private JdbcTemplate jdbctemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	
	public void altaDePersona(Persona persona) {
		String sql = "insert into personas (nombree, apellido) values (?, ?)";
		jdbctemplate.update(sql, persona.getNombre(), persona.getApellido());
	}

	public void recuperarPersona(Long id) {
		String sql = "select idPersona, nombre, apellido from personas where idPesona = ?";
		return jdbctemplate.queryForObject(sql, new Object[] {id }, new RowMapper<Persona>() {
			public Persona mapRow(ResultSet resultSet, int i) throws SQLException {
				Persona persona = new Persona();
				persona.setIdPersona(resultSet.getLong("idPersona"));
				persona.setNombre(resultSet.getString("nombre"));
				persona.setApellido(resultSet.getString("apellido"));
			}
		});
		
	}
	
	public void recuperarPersonas () {
		String sql = "select idPersona, nombre, apellido from personas";
		return jdbctemplate.query(sql, new RowMapper<Persona>() {
			public Persona mapRow(ResultSet resultSet, int i) throws SQLException {
				Persona persona = new Persona();
				persona.setIdPersona(resultSet.getLong("idPersona"));
				persona.setNombre(resultSet.getString("nombre"));
				persona.setApellido(resultSet.getString("apellido"));
			}
		});
		
	}


	public void borrarPersonaPorId(Long idPersona) {
		// TODO Auto-generated method stub
		String sql = "delete from personas where idPersona = ?";
		jdbctemplate.update(sql, idPersona));
	}

	public List<Persona> buscarPersona() {
		// TODO Auto-generated method stub
		return null;
	}

}
