package com.pichincha.test.models.service;

import java.util.List;

import com.pichincha.test.models.Entity.Transaction;

public interface ITransaction {

	//CRUD
	public List<Transaction> getAll(); 
	public Transaction getById(int id); 
	public Transaction save(Transaction transaction); 
	public Transaction update(Transaction transaction) throws Exception; 
	public void deleteById(int id) throws Exception;
	
	//OTHER FUNCTIONS
	public void checkIfExists(int id) throws Exception; 
}
