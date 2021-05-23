package com.acme.stonks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.acme.stonks.domain.model.Bank;
import com.acme.stonks.exception.ResourceNotFoundException;
import com.acme.stonks.domain.repository.BankRepository;
import com.acme.stonks.domain.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired BankRepository bankRepository;
	
	@Override
	public Page<Bank> getAllBanks(Pageable pageable) {
		return bankRepository.findAll(pageable);
	}

	@Override
	public Bank getBankById(Long bankId) {
		return bankRepository.findById(bankId).orElseThrow(() -> new ResourceNotFoundException(
                "Bank", "Id", bankId));
	}
	
	@Override
	public Bank createBank(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	public Bank updateBank(Long bankId, Bank bankRequest) {
        Bank bank = bankRepository.findById(bankId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Bank", "Id", bankId));
        return bankRepository.save(
        		bank.setName(bankRequest.getName()).
        			setRuc(bankRequest.getRuc()).
        			setWebSite(bankRequest.getWebSite()));
	}

	@Override
	public ResponseEntity<?> deleteBank(Long bankId) {
		Bank bank=bankRepository.findById(bankId)
				.orElseThrow(() -> new ResourceNotFoundException(
                        "Bank", "Id", bankId));
		bankRepository.delete(bank);
		return ResponseEntity.ok().build();
	}



	
}
