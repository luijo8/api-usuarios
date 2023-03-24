package com.evaluacion.usuarios.dto;

import java.util.Date;

public interface IDtoListaUsuarios {

	public String getId();
	public String getEmail();
	public Date getCreateAt();
	public Date getModifiedAt();
	public Date getLastLogin();
	public String getToken();
	public Boolean getIsActive();

}
