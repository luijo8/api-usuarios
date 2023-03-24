package com.evaluacion.usuarios.dao;

import org.springframework.data.repository.CrudRepository;

import com.evaluacion.usuarios.entity.Phone;

public interface IPhoneDao extends CrudRepository<Phone, String>{
	

}
