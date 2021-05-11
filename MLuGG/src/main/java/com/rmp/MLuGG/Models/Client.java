package com.rmp.MLuGG.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.annotations.ApiModelProperty;

@EnableJpaRepositories
@Entity
@Table (name = "CLIENT_TBL")
public class Client {
	
	@ApiModelProperty(notes = "ID do Cliente registrado", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@ApiModelProperty(notes = "Nome do client resgistrado", name="name")
	@Column(nullable = false)
	public String name;
	@ApiModelProperty(notes = "UF do client resgistrado", name="uf")
	@Column(nullable = false)
	public String uf;
	@ApiModelProperty(notes = "Cidade do client resgistrado", name="city")
	@Column(nullable = false)
	public String city;
	@ApiModelProperty(notes = "Rua do client resgistrado", name="street")
	@Column(nullable = false)
	public String street;
	@ApiModelProperty(notes = "Complemento do endereço do client registrado", name="complement")
	@Column(nullable = false)
	private String complement;
	@ApiModelProperty(notes = "Número de endereço do client registrado", name="number")
	@Column(nullable = false)
	private Integer number;
	@ApiModelProperty(notes = "Número do CEP do client registrado", name="cep")
	@Column(nullable = false)
	private String cep;
	@ApiModelProperty(notes = "Número de telefone do client registrado", name="phonenumber")
	@Column(nullable = false)
	private String phonenumber;
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	

}
