package com.pichincha.test.models.Entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int number; 
	private String type; 
	private BigDecimal balance; 
	private boolean state; 
	
	@Transient
	private String clientName; 
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "clientId", nullable= false)
	private Client client;
	
	public Account() {}
	public Account(int id, int number, String type, BigDecimal balance, boolean state, Client client) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.balance = balance;
		this.state = state;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getClientName() {
		return client.getName();
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	} 
	
	
}
