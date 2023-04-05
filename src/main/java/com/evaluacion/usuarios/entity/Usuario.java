package com.evaluacion.usuarios.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	private String id;
	
	@Column(length = 30)
	private String name;

	@Column(length = 60)
	private String password;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Phone> phones;

	@Column(length = 50)
	private String email;

	@Column(name = "create_at")
	private Date createAt;

	@Column(name = "modified_at")
	private Date modifiedAt;

	@Column(name = "last_login")
	private Date lastLogin;

	private String token;

	@Column(name = "is_active")
	private Boolean isActive;

}
