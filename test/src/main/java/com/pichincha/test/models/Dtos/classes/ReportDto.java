package com.pichincha.test.models.Dtos.classes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportDto {

	@Id
	private int id; 
	private String date; 
	private String clientName; 
	private int accountNumber; 
	private String accountType; 
	private String transactionType; 
	private BigDecimal initialBalance; 
	private boolean accountState; 
	private BigDecimal transactionAmount; 
	private BigDecimal transactionBalance;
	
	public ReportDto() {}
	public ReportDto(int id, String date, String clientName, int accountNumber, String accountType, String transactionType,
			BigDecimal initialBalance, boolean accountState, BigDecimal transactionAmount, BigDecimal transactionBalance) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.transactionType = transactionType;
		this.initialBalance = initialBalance;
		this.accountState = accountState;
		this.transactionAmount = transactionAmount;
		this.transactionBalance = transactionBalance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public BigDecimal getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(BigDecimal initialBalance) {
		this.initialBalance = initialBalance;
	}
	public boolean isAccountState() {
		return accountState;
	}
	public void setAccountState(boolean accountState) {
		this.accountState = accountState;
	}
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public BigDecimal getTransactionBalance() {
		return transactionBalance;
	}
	public void setTransactionBalance(BigDecimal transactionBalance) {
		this.transactionBalance = transactionBalance;
	}
	
	
	
}
