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
@Table (name = "COMMAND_TBL")
public class Command {
	
	@ApiModelProperty(notes = "ID do comando Registrado", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@ApiModelProperty(notes = "Tipo de comando", name="type")
	@Column(nullable = false)
	public String type;
	
	@ApiModelProperty(notes = "Conteúdo do comando", name="contend")
	@Column(nullable = false)
	public String contend;
	
	@ApiModelProperty(notes = "Conteúdo fala do comando", name="toSpeak")
	@Column(nullable = false)
	public String toSpeak;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContend() {
		return contend;
	}

	public void setContend(String contend) {
		this.contend = contend;
	}

	public String getToSpeak() {
		return toSpeak;
	}

	public void setToSpeak(String toSpeak) {
		this.toSpeak = toSpeak;
	}

}
