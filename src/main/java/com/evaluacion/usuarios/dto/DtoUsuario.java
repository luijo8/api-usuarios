package com.evaluacion.usuarios.dto;

import java.io.Serializable;
import java.util.Date;

public class DtoUsuario implements Serializable {

	private String id;
	private Date createAt;
	private Date modifiedAt;
	private Date lastLogin;
	private String token;
	private Boolean isActive;

	public DtoUsuario(String id, Date createAt, Date modifiedAt, Date lastLogin, String token, Boolean isActive) {
		this.id = id;
		this.createAt = createAt;
		this.modifiedAt = modifiedAt;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
	}

	public DtoUsuario() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	private static final long serialVersionUID = 2544427579246074226L;
}
