package com.larturi.ar.service;

import com.larturi.ar.model.entity.Client;

public interface IClient {
    Client save(Client client);

    Client findById(Integer id);

    void delete(Client client);
}
