package com.acme.stonks.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.acme.stonks.domain.model.TermDeposit;

public interface TermDepositService {
	Page<TermDeposit> getAllTermDepositsByBankId(Long bankId,Pageable pageable);
	TermDeposit getTermDepositByIdAndBankId(Long bankId, Long termDepositId);
	TermDeposit createTermDeposit(Long bankId, TermDeposit termDeposit);
	TermDeposit updateTermDeposit(Long bankId, Long termDepositId, TermDeposit teaDetails);
	ResponseEntity<?> deleteTermDeposit(Long bankId, Long termDepositId);
}
