package com.rmp.MLuGG.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.annotations.ApiModelProperty;

@EnableJpaRepositories
@Entity
@Table (name = "SERVICES_TBL")
public class ServiceOn {
	
	@ApiModelProperty(notes = "ID do serviço Registrado", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "Nome do Serviço resgistrado", name="serviceon")
	private String serviceon;
	
	@ApiModelProperty(notes = "Observações sobre o serviço", name="obs")
	private String obs;
	
	@ApiModelProperty(notes = "Dia de inicio do serviço", name="dayinn")
	private String dayinn;
	
	@ApiModelProperty(notes = "Dias de encerramento do serviço", name="dayout")
	private String dayout;
	
	@ManyToOne
	@ApiModelProperty(notes = "Cliente do serviço", name="client")
	private Client client;

	@ApiModelProperty(notes = "Custo do serviço", name="cost")
	private Float cost;
	
	@ApiModelProperty(notes = "Localização do serviço", name="location")
	private String location;
	
	@ManyToOne
	@ApiModelProperty(notes = "Produto usado no serviço", name="product")
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceon() {
		return serviceon;
	}

	public void setServiceon(String serviceon) {
		this.serviceon = serviceon;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getDayinn() {
		return dayinn;
	}

	public void setDayinn(String dayinn) {
		this.dayinn = dayinn;
	}

	
	public String getDayout() {
		return dayout;
	}

	public void setDayout(String dayout) {
		this.dayout = dayout;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
