package com.imorales.losheroes.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imorales.losheroes.apirest.models.dao.IClientDao;
import com.imorales.losheroes.apirest.models.entity.Client;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clientDao;

	@Override
	public List<Client> findAll() {
		return (List<Client>) clientDao.findAll();
	}

	@Override
	public Client findById(Long id) {
		return clientDao.findById(id).orElse(null);
	}

	@Override
	public Client save(Client client) {
		return clientDao.save(client);
	}

	@Override
	public void delete(Long id) {
		clientDao.deleteById(id);
	}
}
