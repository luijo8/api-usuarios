package com.evaluacion.usuarios.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.evaluacion.usuarios.dto.IDtoListaUsuarios;
import com.evaluacion.usuarios.entity.Usuario;

public interface IUsuarioService {
	
	public ResponseEntity<Object> validaUsuario(String id, String password, Boolean isActive);

	public ResponseEntity<Object> crear(Usuario newUser);
	
	public List<IDtoListaUsuarios> listaUsuarios();

}
