package com.pichincha.test.models.implement;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pichincha.test.models.Dao.TransactionDao;
import com.pichincha.test.models.Entity.Account;
import com.pichincha.test.models.Entity.Transaction;
import com.pichincha.test.models.service.IAccount;
import com.pichincha.test.models.service.ITransaction;
import com.pichincha.test.utils.enums.TransactionType;

@Service
@Transactional
public class TransactionImpl implements ITransaction{

	
	@Autowired 
	TransactionDao transactionDao; 
	
	@Autowired 
	IAccount accountService; 
	
	
	@Override
	public List<Transaction> getAll() {
		return transactionDao.findAll(); 
	}

	@Override
	public Transaction getById(int id) {
		return transactionDao.findById(id); 
	}

	@Override
	public Transaction save(Transaction transaction) throws Exception {
		BigDecimal lastBalance = getLastBalance(transaction.getAccountId()); 
		BigDecimal actualBalance = sumAmountToBalance(transaction, lastBalance); 
		transaction.setBalance(actualBalance);
		transaction.setDate(LocalDateTime.now());
		
		if(transaction.getType() == TransactionType.DEBITO) 
			transaction.setAmount(transaction.getAmount().multiply(new BigDecimal(-1)));
			
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

	
	//---------- OTHER FUNCTIONS----------
	@Override
	public void checkIfExists(int id) throws Exception {
		if(getById(id) == null) {
			throw new Exception("ID " + id + " does not exist"); 
		}
	}

	@Override
	public BigDecimal getLastBalance(int accountId) throws Exception {
		accountService.checkIfExists(accountId);
		BigDecimal lastBalance = transactionDao.getLastBalance(accountId); 
		if(lastBalance != null) return lastBalance; 
		Account account = accountService.getById(accountId); 
		return account.getBalance(); 
		
	}

	@Override
	public BigDecimal sumAmountToBalance(Transaction transaction, BigDecimal lastBalance) throws Exception {
		
		BigDecimal actualBalance = BigDecimal.ZERO; 
		if(transaction.getType() == TransactionType.CREDITO) return lastBalance.add(transaction.getAmount()); 
		else if(transaction.getType() == TransactionType.DEBITO) {
			actualBalance = lastBalance.subtract(transaction.getAmount()); 
			if(actualBalance.compareTo(BigDecimal.ZERO) < 0) 
				throw new Exception("SALDO NO DISPONIBLE"); 
			return actualBalance; 
		}
		throw new Exception("INVALID TRANSACTION TYPE"); 
	}

}
