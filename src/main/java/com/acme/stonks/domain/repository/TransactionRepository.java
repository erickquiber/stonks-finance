package com.acme.stonks.domain.repository;

import com.acme.stonks.domain.model.Transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    Page<Transaction> findByAccountTermDepositId(Long accountTermDepositId, Pageable pageable);
}
