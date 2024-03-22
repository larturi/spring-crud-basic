package com.larturi.ar.controller;

import com.larturi.ar.model.dto.ClientDto;
import com.larturi.ar.model.entity.Client;
import com.larturi.ar.model.payload.MessageResponse;
import com.larturi.ar.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private IClientService clientService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/client")
    public ResponseEntity listAll() {

        List<Client> clients = clientService.listAll();

        if(clients == null) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("No hay registros")
                    .object(null)
                    .build(), HttpStatus.OK);
        } else {
            return new ResponseEntity(MessageResponse.builder()
                    .message("List of Clients")
                    .object(clients)
                    .build(), HttpStatus.OK);
        }
    }

    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody ClientDto clientDto) {
        Client clientSave = null;

        try {
            clientSave =  clientService.save(clientDto);

            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Created!")
                    .object(ClientDto.builder()
                                    .id(clientSave.getId())
                                    .firstname(clientSave.getFirstname())
                                    .lastname(clientSave.getLastname())
                                    .email(clientSave.getEmail())
                                    .createdAt(clientSave.getCreatedAt())
                                    .build())
                            .build()
                        ,HttpStatus.CREATED
                    );
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(exDt.getMessage())
                            .object(null)
                            .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/client/{id}")
    public ResponseEntity<?> update(@RequestBody ClientDto clientDto, @PathVariable Integer id) {
        Client clientUpdate = null;
        try {
            if(!clientService.existsById(id)) {
                clientUpdate = clientService.save(clientDto);
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("Updated!")
                        .object(ClientDto.builder()
                                .id(clientUpdate.getId())
                                .firstname(clientUpdate.getFirstname())
                                .lastname(clientUpdate.getLastname())
                                .email(clientUpdate.getEmail())
                                .createdAt(clientUpdate.getCreatedAt())
                                .build())
                        .build(), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("El registro que intenta actualizar no existe")
                        .object(null)
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(exDt.getMessage())
                    .object(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/client/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Client clientDelete = clientService.findById(id);
            clientService.delete(clientDelete);
            return new ResponseEntity<>(clientDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(exDt.getMessage())
                    .object(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/client/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {

        Client client = clientService.findById(id);

        if(client == null) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("El registro con id no existe")
                    .object(null)
                    .build(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(MessageResponse.builder()
                .message("")
                .object(ClientDto.builder()
                        .id(client.getId())
                        .firstname(client.getFirstname())
                        .lastname(client.getLastname())
                        .email(client.getEmail())
                        .createdAt(client.getCreatedAt())
                        .build())
                .build(), HttpStatus.OK);
    }
}
