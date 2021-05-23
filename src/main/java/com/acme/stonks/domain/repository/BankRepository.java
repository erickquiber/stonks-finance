package com.acme.stonks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.stonks.domain.model.Bank;
import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long>{
	public Optional<Bank> findByName(String name);
}
