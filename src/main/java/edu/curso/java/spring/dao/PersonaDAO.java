package edu.curso.java.spring.dao;

import java.util.List;

import edu.curso.java.spring.bo.Persona;

public interface PersonaDAO {
	
	public void altaDePersona(Persona persona);
	
	public void recuperarPersona(Long id);

	public Persona recuperarPersonas();

	public void borrarPersonaPorId(Long idPersona);

	public List<Persona> buscarPersona();

}
