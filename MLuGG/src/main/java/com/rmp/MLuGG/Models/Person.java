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
@Table (name = "PERSON_TBL")
public class Person {

	@ApiModelProperty(notes = "ID do usuário Registrado", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@ApiModelProperty(notes = "Nome de usuário resgistrado", name="username")
	@Column(nullable = false)
	public String username;
	@ApiModelProperty(notes = "Senha de usuário resgistrado", name="pass")
	@Column(nullable = false)
	public String pass;
	@ApiModelProperty(notes = "Email de usuário resgistrado", name="email")
	@Column(nullable = false)
	public String email;
	@ApiModelProperty(notes = "Papel do usuário registrado", name="role")
	@Column(nullable = false)
	private String role;
	
	@Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
