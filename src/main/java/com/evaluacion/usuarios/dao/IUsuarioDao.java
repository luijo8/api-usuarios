package com.evaluacion.usuarios.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.evaluacion.usuarios.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, String>{

	public Usuario findByEmail(String email);
	
	public Usuario findByIdAndPasswordAndIsActive(String id, String password, Boolean isActive);	
	
}
