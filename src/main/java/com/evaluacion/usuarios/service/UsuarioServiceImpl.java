package com.evaluacion.usuarios.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evaluacion.usuarios.dao.IPhoneDao;
import com.evaluacion.usuarios.dao.IUsuarioDao;
import com.evaluacion.usuarios.dto.DtoError;
import com.evaluacion.usuarios.dto.DtoToken;
import com.evaluacion.usuarios.dto.DtoUsuario;
import com.evaluacion.usuarios.dto.IDtoListaUsuarios;
import com.evaluacion.usuarios.entity.Usuario;
import com.evaluacion.usuarios.security.JWTToken;
import com.evaluacion.utils.Utilidades;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;

	@Autowired
	private IPhoneDao phoneDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<Object> validaUsuario(String id, String password, Boolean isActive) {
		try {
			Usuario usr = usuarioDao.findByIdAndPasswordAndIsActive(id, password, isActive);
			if (usr == null)
				return ResponseEntity.status(403).body(new DtoError("Credenciales inválidas!"));
			
			DtoToken token = new DtoToken(JWTToken.getJWTToken(id, usr.getId()));
			if (token == null || token.getToken().isBlank())
				return ResponseEntity.status(500).body(new DtoError("Error al generar el Token!"));
			else 
				return ResponseEntity.status(201).body(new DtoToken(JWTToken.getJWTToken(id, usr.getId())));
		}catch (Exception e) {
			return ResponseEntity.status(500).body(new DtoError(e.getMessage()));
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<IDtoListaUsuarios> listaUsuarios() {
		return usuarioDao.listaUsuarios();
	}

	@Override
	@Transactional
	public ResponseEntity<Object> crear(Usuario newUser) {
		try {
			if (newUser.getEmail() == null || newUser.getEmail().isBlank())
				return ResponseEntity.status(403).body(new DtoError("Correo inválido!"));

			if (!Utilidades.validaExpRegularEmail(newUser.getEmail()))
				return ResponseEntity.status(403).body(new DtoError("Fomato de correo inválido!"));

			if (!Utilidades.validaExpRegularPassword(newUser.getPassword()))
				return ResponseEntity.status(403).body(new DtoError("Fomato de password inválido!"));

			
			Usuario usrMail = usuarioDao.findByEmail(newUser.getEmail());
			if (usrMail != null)
				return ResponseEntity.status(403).body(new DtoError("El correo ya está registrado!"));

			newUser.setId(String.valueOf(UUID.nameUUIDFromBytes(newUser.getName().getBytes())));
			newUser.setCreateAt(new Date());
			newUser.setLastLogin(new Date());
			newUser.setModifiedAt(new Date());
			newUser.setToken(
					String.valueOf(UUID.nameUUIDFromBytes((newUser.getName() + newUser.getEmail()).getBytes())));
			newUser.setIsActive(true);
			if (newUser.getPhones() != null)
				newUser.getPhones().forEach(phone -> phoneDao.save(phone));
			if (usuarioDao.save(newUser) != null)
				return ResponseEntity.status(201).body(new DtoUsuario(newUser.getId(), newUser.getCreateAt(),
						newUser.getModifiedAt(), newUser.getLastLogin(), newUser.getToken(), newUser.getIsActive()));
			else
				return ResponseEntity.status(400).body(new DtoError("Error al crear el suaurio!"));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new DtoError(e.getMessage()));
		}
	}

}
