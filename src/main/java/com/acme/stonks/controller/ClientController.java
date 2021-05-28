package com.acme.stonks.controller;

import com.acme.stonks.domain.model.Client;
import com.acme.stonks.domain.service.ClientService;
import com.acme.stonks.resource.ClientResource;
import com.acme.stonks.resource.SaveClientResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@Tag(name="Clients",description = "Client API")
@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public Page<ClientResource> getAllClients(Pageable pageable) {

        Page<Client> clientsPage = clientService.getAllClients(pageable);
        List<ClientResource> resources = clientsPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/clients/{clientId}")
    public ClientResource getClientById(@PathVariable(value = "clientId") Long clientId) {
        return convertToResource(clientService.getClientById(clientId));
    }

    @PostMapping("/clients")
    public ClientResource createClient(
            @Valid @RequestBody SaveClientResource resource) {
        Client client = convertToEntity(resource);
        return convertToResource(clientService.createClient(client));

    }

    @PutMapping("/clients/{clientId}")
    public ClientResource updateClient(@PathVariable Long clientId,
                                     @Valid @RequestBody SaveClientResource resource) {
        Client client = convertToEntity(resource);
        return convertToResource(
                clientService.updateClient(clientId, client));
    }

    @DeleteMapping("/clients/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        return clientService.deleteClient(clientId);
    }




    private Client convertToEntity(SaveClientResource resource) {
        return mapper.map(resource, Client.class);
    }

    private ClientResource convertToResource(Client entity) {
        return mapper.map(entity, ClientResource.class);
    }


}
