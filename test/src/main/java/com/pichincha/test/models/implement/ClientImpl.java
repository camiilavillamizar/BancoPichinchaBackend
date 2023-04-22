package com.pichincha.test.models.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pichincha.test.models.Dao.ClientDao;
import com.pichincha.test.models.Entity.Client;
import com.pichincha.test.models.service.IClient;

@Service
@Transactional
public class ClientImpl implements IClient{

	
	@Autowired
	ClientDao clientDao; 
	
	//------------- CRUD----------------
	@Override
	public List<Client> getAll() {
		return clientDao.findAll(); 
	}

	@Override
	public Client getById(int id) {
		return clientDao.findById(id); 
	}

	@Override
	public Client save(Client client) {
		return clientDao.save(client); 
	}

	@Override
	public Client update(Client client) throws Exception {
		checkIfExists(client.getId()); 
		return clientDao.save(client);
	}

	@Override
	public void deleteById(int id) throws Exception {
		checkIfExists(id);
		clientDao.deleteById(id);
	}

	//----------OTHER FUNCTIONS
	@Override
	public void checkIfExists(int id) throws Exception {
		
		if(getById(id) == null) 
			throw new Exception("ID " + id + " does not exist"); 
	}

}
