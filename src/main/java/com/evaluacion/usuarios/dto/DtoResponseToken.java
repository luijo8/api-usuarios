package com.evaluacion.usuarios.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DtoResponseToken implements Serializable {
	
	private String token;

	private static final long serialVersionUID = 5862819041898929346L;
}
