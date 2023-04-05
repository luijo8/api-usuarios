package com.evaluacion.usuarios.dto;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoRequestUsuario {
	
	private String name;
	private String password;
	private String email;
	private List<DtoRequestPhone> phones;
	@JsonIgnore
	private final Date createAt = new Date();
	@JsonIgnore
	private final Date modifiedAt = new Date();
	@JsonIgnore
	private final Date lastLogin = new Date();
}
