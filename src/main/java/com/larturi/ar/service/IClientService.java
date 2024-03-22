package com.larturi.ar.service;

import com.larturi.ar.model.dto.ClientDto;
import com.larturi.ar.model.entity.Client;

import java.util.List;

public interface IClientService {
    List<Client> listAll();

    Client save(ClientDto client);

    Client findById(Integer id);

    void delete(Client client);

    boolean existsById(Integer id);
}
