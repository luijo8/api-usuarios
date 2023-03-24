package com.evaluacion.usuarios.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.evaluacion.usuarios.dto.IDtoListaUsuarios;
import com.evaluacion.usuarios.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, String>{

	public Usuario findByEmail(String email);
	
	public Usuario findByIdAndPasswordAndIsActive(String id, String password, Boolean isActive);	
	
	@Query(value = "select u from Usuario u")
	public List<IDtoListaUsuarios> listaUsuarios();
		
	
	
}
