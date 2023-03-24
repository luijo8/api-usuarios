package com.evaluacion.usuarios.dto;

import java.io.Serializable;

public class DtoToken implements Serializable {

	private String token;

	public DtoToken(String token) {
		this.token = token;
	}

	public DtoToken() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	private static final long serialVersionUID = 5862819041898929346L;
}
