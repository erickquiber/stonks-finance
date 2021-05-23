package com.acme.stonks.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.stonks.domain.model.Bank;
import com.acme.stonks.domain.service.BankService;
import com.acme.stonks.resource.BankResource;
import com.acme.stonks.resource.SaveBankResource;

@RestController
@RequestMapping("/api")
public class BankController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BankService bankService;
	
	@GetMapping("/banks")
	public Page<BankResource> getAllBanks(Pageable pageable){
		Page<Bank> banksPage=bankService.getAllBanks(pageable);
		List<BankResource> resources=banksPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
	}
	
	@GetMapping("/banks/{bankId}")
	public BankResource getBankById(@PathVariable(value="bankId") Long bankId) {
		return convertToResource(bankService.getBankById(bankId));
	}
	
	@PostMapping("/banks")
	public BankResource createBank(@Valid @RequestBody SaveBankResource resource) {
		Bank bank=convertToEntity(resource);
		return convertToResource(bankService.createBank(bank));
	}
	
	@PutMapping("/banks/{bankId}")
	public BankResource updateBank(@PathVariable Long bankId, 
			@Valid @RequestBody SaveBankResource resource) {
		Bank bank=convertToEntity(resource);
		return convertToResource(bankService.updateBank(bankId, bank));
	}
	
	@DeleteMapping("/banks/{bankId}")
	public ResponseEntity<?> deleteBank(@PathVariable Long bankId){
		return bankService.deleteBank(bankId);
	}
	
	private Bank convertToEntity(SaveBankResource resource) {
		return mapper.map(resource, Bank.class);
	}
	
	private BankResource convertToResource(Bank entity) {
		return mapper.map(entity, BankResource.class);
	}
	
}
