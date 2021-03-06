package com.acme.stonks.service;

import com.acme.stonks.domain.model.Client;
import com.acme.stonks.domain.repository.ClientRepository;
import com.acme.stonks.domain.service.ClientService;
import com.acme.stonks.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;




    @Override
    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(()->new ResourceNotFoundException("Client","Id",clientId));
    }

    @Override
    public Client createClient(Client client) {
        return  clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long clientId, Client clientRequest) {
        return clientRepository.findById(clientId).map(client -> {
            client.setDni(clientRequest.getDni());
            client.setAddress(clientRequest.getAddress());
            client.setCountry(clientRequest.getCountry());
            client.setFirstName(clientRequest.getFirstName());
            client.setLastName(clientRequest.getLastName());
            client.setUsername(clientRequest.getUsername());
            client.setPassword(clientRequest.getPassword());
            client.setPhone(clientRequest.getPhone());

        return clientRepository.save(client);
        }).orElseThrow(()->new ResourceNotFoundException("Client","Id",clientId));
    }

    @Override
    public ResponseEntity<?> deleteClient(Long clientId) {
        return clientRepository.findById(clientId).map(client -> {
            clientRepository.delete(client);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Client","Id",clientId));
    }

    @Override
    public Client getClientByUsernameAndPassword(String username, String password) {
        return  clientRepository.findByUsernameAndPassword(username ,password)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Client not found with Username " + username+
                                " and Password " + password));
    }
}
