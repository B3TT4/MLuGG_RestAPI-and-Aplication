package com.rmp.MLuGG.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.annotations.ApiModelProperty;

@EnableJpaRepositories
@Entity
@Table (name = "PRODUCT_TBL")
public class Product {
	
	@ApiModelProperty(notes = "ID do produto Registrado", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(notes = "Nome do produto resgistrado", name="product")
	private String product;
	@ApiModelProperty(notes = "Obervações do produto resgistrado", name="func")
	private String obs;
	@ApiModelProperty(notes = "Estado do produto resgistrado", name="state")
	private String state;
	@ApiModelProperty(notes = "Custo, por dia, do produto resgistrado", name="costperday")
	private Float costperday;
	@ApiModelProperty(notes = "Custo, por hora, do produto resgistrado", name="costperhour")
	private Float costperhour;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Float getCostperday() {
		return costperday;
	}
	public void setCostperday(Float costperday) {
		this.costperday = costperday;
	}
	public Float getCostperhour() {
		return costperhour;
	}
	public void setCostperhour(Float costperhour) {
		this.costperhour = costperhour;
	}

}
