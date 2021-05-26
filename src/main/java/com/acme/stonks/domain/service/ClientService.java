package com.acme.stonks.domain.service;

import com.acme.stonks.domain.model.Client;
import com.acme.stonks.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    Page<Client> getAllClients( Pageable pageable);
    Client getClientById(Long clientId);
    Client createClient(Client client);
    Client updateClient(Long clientId, Client clientRequest);
    ResponseEntity<?> deleteClient(Long clientId);
}
