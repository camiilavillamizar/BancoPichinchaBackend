package com.pichincha.test.models.implement;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pichincha.test.models.Dao.TransactionDao;
import com.pichincha.test.models.Entity.Transaction;
import com.pichincha.test.models.service.ITransaction;

@Service
@Transactional
public class TransactionImpl implements ITransaction{

	
	@Autowired 
	TransactionDao transactionDao; 
	
	@Override
	public List<Transaction> getAll() {
		return transactionDao.findAll(); 
	}

	@Override
	public Transaction getById(int id) {
		return transactionDao.findById(id); 
	}

	@Override
	public Transaction save(Transaction transaction) {
		return transactionDao.save(transaction); 
	}

	@Override
	public Transaction update(Transaction transaction) throws Exception {
		checkIfExists(transaction.getId());
		return transactionDao.save(transaction); 
	}

	@Override
	public void deleteById(int id) throws Exception {
		checkIfExists(id);
		transactionDao.deleteById(id);
	}

	@Override
	public void checkIfExists(int id) throws Exception {
		if(getById(id) == null) {
			throw new Exception("ID " + id + " does not exist"); 
		}
		
	}

}
