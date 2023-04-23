package com.pichincha.test.models.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.test.models.Entity.Transaction;

@Repository
public interface TransactionDao extends CrudRepository<Transaction, Long>{

	//GETS
	public List<Transaction> findAll(); 
	public Transaction findById(int id); 
	
	//POST/PUT
	public Transaction save(Transaction transaction); 
	
	//DELETE
	public void deleteById(int id); 
}
