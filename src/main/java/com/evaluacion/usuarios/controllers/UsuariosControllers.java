package com.evaluacion.usuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.usuarios.dto.DtoRequestUsuario;
import com.evaluacion.usuarios.service.IUsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Usuarios")
public class UsuariosControllers {

	@Autowired
	private IUsuarioService usuarioService;

	@ApiOperation(value = "Crea Token Acceso")
	@PostMapping("/api/user/signin")
	public ResponseEntity<Object> createToken(@RequestHeader(required = true, name = "id") String id,
			@RequestHeader(required = true, name = "password") String password) {
		return usuarioService.validaUsuario(id, password, true);
	}

	@ApiOperation(value = "Crea Usuario")
	@PostMapping("/api/user")
	public ResponseEntity<Object> createTest(@RequestBody(required = true) DtoRequestUsuario newUser) {
		return usuarioService.crear(newUser);
	}

	@ApiOperation(value = "Lista Usuarios")
	@GetMapping("/api/user/getall")
	public ResponseEntity<Object> getAll() {
		return usuarioService.listaUsuarios();
	}

}
