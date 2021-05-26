package com.acme.stonks.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.acme.stonks.domain.model.Bank;

public interface BankService {
	Page<Bank> getAllBanks(Pageable pageable);
	Bank getBankById(Long bankId);
	Bank createBank(Bank bank);
	Bank updateBank(Long bankId, Bank bankRequest);
	ResponseEntity<?> deleteBank(Long bankId);
}
