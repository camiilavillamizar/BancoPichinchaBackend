package com.pichincha.test.models.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.pichincha.test.utils.classes.Person;

@Entity
@Table(name = "clients")
public class Client extends Person{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password; 
	
	@Column(nullable = false)
	private boolean state;

	public Client() {}
	
	public Client(int id, String password, boolean state) {
		super();
		this.id = id;
		this.password = password;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	} 
	
	
}
