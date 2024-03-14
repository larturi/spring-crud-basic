package com.larturi.ar.model.dao;

import com.larturi.ar.model.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDAO extends CrudRepository<Client, Integer> {

}
