package com.larturi.ar.service.impl;

import com.larturi.ar.model.dao.ClientDAO;
import com.larturi.ar.model.dto.ClientDto;
import com.larturi.ar.model.entity.Client;
import com.larturi.ar.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientImplService implements IClientService {

    @Autowired
    public List<Client> listAll() {
       return (List) clientDao.findAll();
    }

    @Autowired
    private ClientDAO clientDao;

    @Transactional
    @Override
    public Client save(ClientDto clientDto) {
        Client client = Client.builder()
                    .id(clientDto.getId())
                    .firstname(clientDto.getFirstname())
                    .lastname(clientDto.getLastname())
                    .email(clientDto.getEmail())
                    .createdAt(clientDto.getCreatedAt())
                .build();
        return clientDao.save(client);
    }

    @Transactional(readOnly = true)
    @Override
    public Client findById(Integer id) {
        return clientDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }

    @Override
    public boolean existsById(Integer id) {
        return clientDao.existsById(id);
    }
}
