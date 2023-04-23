package com.pichincha.test.models.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.test.models.Entity.Account;
import com.pichincha.test.models.Entity.Client;

@Repository
public interface AccountDao extends CrudRepository<Account, Long>{
	
	//GETS
	public List<Account> findAll(); 
	public Account findById(int id); 
	public List<Account> findByClient(Client client); 
	//POST/PUT
	public Account save(Account account); 
	//DELETE
	public void deleteById(int id); 

}
 