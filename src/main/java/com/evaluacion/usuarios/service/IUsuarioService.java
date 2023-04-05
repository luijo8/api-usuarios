package com.evaluacion.usuarios.service;

import org.springframework.http.ResponseEntity;

import com.evaluacion.usuarios.dto.DtoRequestUsuario;

public interface IUsuarioService {
	
	public ResponseEntity<Object> validaUsuario(String id, String password, Boolean isActive);

	public ResponseEntity<Object> crear(DtoRequestUsuario userDto);

	public ResponseEntity<Object> listaUsuarios();

}
