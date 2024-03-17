package com.larturi.ar.controller;

import com.larturi.ar.model.entity.Client;
import com.larturi.ar.service.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private IClient clientService;

    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client client) {
        return clientService.save(client);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/client")
    public Client update(@RequestBody Client client) {
        return clientService.save(client);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/client/{id}")
    public void delete(@PathVariable Integer id) {
        Client clientToDelete = clientService.findById(id);

        if(clientToDelete == null) {
            logger.info("Client with ID {} not found", id);
            throw new ClientNotFoundException("Client with ID " + id + " not found");
        } else {
            logger.info("Deleting client: {}", clientToDelete);
        }


        clientService.delete(clientToDelete);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/client/{id}")
    public Client findById(@PathVariable Integer id) {
        return clientService.findById(id);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Client not found")
    public class ClientNotFoundException extends RuntimeException {
        public ClientNotFoundException(String message) {
            super(message);
        }
    }
}
