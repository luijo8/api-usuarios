package com.evaluacion.usuarios.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class DtoResponseUsuario implements Serializable {

	private String id;
	private String email;
	private Date createAt;
	private Date modifiedAt;
	private Date lastLogin;
	private String token;
	private Boolean isActive;

	private static final long serialVersionUID = 2544427579246074226L;
}
