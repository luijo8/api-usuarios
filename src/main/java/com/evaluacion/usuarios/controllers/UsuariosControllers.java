package com.evaluacion.usuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.usuarios.entity.Usuario;
import com.evaluacion.usuarios.service.IUsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Usuarios")
public class UsuariosControllers {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@ApiOperation(value = "Crea Token Acceso")
	@PostMapping("/api/usuarios/createtoken")		
	public ResponseEntity<Object> createToken (@RequestHeader (required = true, name = "id") String id, @RequestHeader(required = true, name = "password") String password) {
		return usuarioService.validaUsuario(id, password, true);
	}
	
	@ApiOperation(value = "Lista Usuarios")
	@GetMapping("/api/usuarios/getall")
	public ResponseEntity<Object> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listaUsuarios());
	}
	
	@ApiOperation(value = "Crea Usuario")
	@PostMapping("/api/usuarios/")
	public ResponseEntity<Object> create (@RequestBody(required = true) Usuario newUser){		
		return usuarioService.crear(newUser);		
	}
	
}
