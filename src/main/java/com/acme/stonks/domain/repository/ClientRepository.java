package com.acme.stonks.domain.repository;

import com.acme.stonks.domain.model.Client;
import com.acme.stonks.domain.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUsernameAndPassword(String username, String  password);
}
