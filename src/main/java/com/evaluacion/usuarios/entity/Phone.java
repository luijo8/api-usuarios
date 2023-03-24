package com.evaluacion.usuarios.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phones")
public class Phone implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer number;
	private Integer cityCode;
	private Integer conutryCode;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public Integer getConutryCode() {
		return conutryCode;
	}

	public void setConutryCode(Integer conutryCode) {
		this.conutryCode = conutryCode;
	}

	private static final long serialVersionUID = 3279428879505764511L;
}
