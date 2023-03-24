package com.evaluacion.usuarios.dto;

import java.io.Serializable;

public class DtoError implements Serializable{
	
	private String mensaje;
	
	public DtoError(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public DtoError() {

	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	private static final long serialVersionUID = -76402233292632467L;
}
