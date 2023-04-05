package com.evaluacion.usuarios.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DtoResponseError implements Serializable{
	
	private String mensaje;
	
	private static final long serialVersionUID = -76402233292632467L;
}
