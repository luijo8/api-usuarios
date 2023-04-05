package com.evaluacion.usuarios.service;

import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluacion.security.JWTToken;
import com.evaluacion.usuarios.dao.IPhoneDao;
import com.evaluacion.usuarios.dao.IUsuarioDao;
import com.evaluacion.usuarios.dto.DtoRequestUsuario;
import com.evaluacion.usuarios.dto.DtoResponseError;
import com.evaluacion.usuarios.dto.DtoResponseUsuario;
import com.evaluacion.usuarios.dto.DtoResponseToken;
import com.evaluacion.usuarios.entity.Usuario;
import com.evaluacion.utils.Utilidades;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;

	@Autowired
	private IPhoneDao phoneDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<Object> validaUsuario(String id, String password, Boolean isActive) {
		try {
			Usuario usr = usuarioDao.findByIdAndPasswordAndIsActive(id, password, isActive);
			if (usr == null)
				return ResponseEntity.status(403).body(new DtoResponseError("Credenciales inválidas!"));
			
			DtoResponseToken token = new DtoResponseToken(JWTToken.getJWTToken(id, usr.getId()));
			if (token == null || token.getToken().isBlank())
				return ResponseEntity.status(500).body(new DtoResponseError("Error al generar el Token!"));
			else 
				return ResponseEntity.status(201).body(new DtoResponseToken(JWTToken.getJWTToken(id, usr.getId())));
		}catch (Exception e) {
			return ResponseEntity.status(500).body(new DtoResponseError(e.getMessage()));
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<Object> listaUsuarios() {
		return ResponseEntity.status(201).body(
				usuarioDao.findAll().stream().map(
						usuario -> modelMapper.map(
								usuario, DtoResponseUsuario.class)).collect(Collectors.toList()));
	}
	
	@Override
	@Transactional
	public ResponseEntity<Object> crear(DtoRequestUsuario userDto) {
		try {
			Usuario newUser = modelMapper.map(userDto, Usuario.class);
			if (newUser.getEmail() == null || newUser.getEmail().isBlank())
				return ResponseEntity.status(403).body(new DtoResponseError("Correo inválido!"));

			if (!Utilidades.validaExpRegularEmail(newUser.getEmail()))
				return ResponseEntity.status(403).body(new DtoResponseError("Fomato de correo inválido!"));

			if (!Utilidades.validaExpRegularPassword(newUser.getPassword()))
				return ResponseEntity.status(403).body(new DtoResponseError("Fomato de password inválido!"));
			
			Usuario usrMail = usuarioDao.findByEmail(newUser.getEmail());
			if (usrMail != null)
				return ResponseEntity.status(403).body(new DtoResponseError("El correo ya está registrado!"));
			
			newUser.setId(String.valueOf(UUID.nameUUIDFromBytes(newUser.getName().getBytes())));
			newUser.setToken(String.valueOf(UUID.nameUUIDFromBytes((newUser.getName() + newUser.getEmail()).getBytes())));
			newUser.setIsActive(true);
			if (newUser.getPhones() != null)
				newUser.getPhones().forEach(phone -> phoneDao.save(phone));
			Usuario usuario = usuarioDao.save(newUser);
			if (usuario != null) {
				DtoResponseUsuario dtoUsuario = modelMapper.map(usuario, DtoResponseUsuario.class);
				return ResponseEntity.status(201).body(dtoUsuario);
			}
			else
				return ResponseEntity.status(400).body(new DtoResponseError("Error al crear el usuario!"));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new DtoResponseError(e.getMessage()));
		}
	}

}
