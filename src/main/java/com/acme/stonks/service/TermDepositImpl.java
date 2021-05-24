package com.acme.stonks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.acme.stonks.domain.model.TermDeposit;
import com.acme.stonks.domain.repository.BankRepository;
import com.acme.stonks.domain.repository.TermDepositRepository;
import com.acme.stonks.domain.service.TermDepositService;
import com.acme.stonks.exception.ResourceNotFoundException;

@Service
public class TermDepositImpl implements TermDepositService{
	
	@Autowired BankRepository bankRepository;
	
	@Autowired
	private TermDepositRepository termDepositRepository;

	@Override
	public Page<TermDeposit> getAllTermDepositsByBankId(Long bankId, Pageable pageable) {
		return termDepositRepository.findByBankId(bankId, pageable);
	}

	@Override
	public TermDeposit getTermDepositByIdAndBankId(Long bankId, Long termDepositId) {
		return termDepositRepository.findByIdAndBankId(termDepositId, bankId)
				.orElseThrow(() -> new ResourceNotFoundException(
                        "TEA not found with Id " + termDepositId +
                        " and BankId " + bankId));
	}

	@Override
	public TermDeposit createTermDeposit(Long bankId, TermDeposit termDeposit) {
		return bankRepository.findById(bankId).map(bank -> {
			termDeposit.setBank(bank);
			return termDepositRepository.save(termDeposit);
		}).orElseThrow(() -> new ResourceNotFoundException(
                "Bank", "Id", bankId));
	}

	@Override
	public TermDeposit updateTermDeposit(Long bankId, Long termDepositId, TermDeposit tdDetails) {
		if(!bankRepository.existsById(bankId))
            throw new ResourceNotFoundException("Bank", "Id", bankId);
		
		return termDepositRepository.findById(termDepositId).map(termDeposit->{
			termDeposit.setName(tdDetails.getName())
			.setTea(tdDetails.getTea())
			.setMinDay(tdDetails.getMinDay())
			.setMaxDay(tdDetails.getMaxDay())
			.setMinAmount(tdDetails.getMinAmount());
			return termDepositRepository.save(termDeposit);
		}).orElseThrow(() -> new ResourceNotFoundException("TermDeposit", "Id", termDepositId));
	}

	@Override
	public ResponseEntity<?> deleteTermDeposit(Long bankId, Long termDepositId) {
		return termDepositRepository.findByIdAndBankId(termDepositId, bankId).map(termDeposit->{
			termDepositRepository.delete(termDeposit);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(
                "Term Deposit not found with Id " + termDepositId + " and BankId " + bankId));
	}
	

}
