package com.imorales.losheroes.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.imorales.losheroes.apirest.models.entity.Client;

public interface IClientDao extends CrudRepository<Client, Long> {

}
