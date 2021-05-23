package com.acme.stonks.domain.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.stonks.domain.model.TermDeposit;

public interface TermDepositRepository extends JpaRepository<TermDeposit, Long>{
	Page<TermDeposit> findByBankId(Long bankId, Pageable pageable);
	Optional<TermDeposit> findByIdAndBankId(Long id, Long bankid);
}
