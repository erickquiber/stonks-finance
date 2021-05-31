package com.acme.stonks.domain.repository;

import com.acme.stonks.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
}
