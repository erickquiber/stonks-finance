package com.acme.stonks.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.acme.stonks.domain.model.AccountTermDeposit;
import com.acme.stonks.domain.service.AccountTermDepositService;
import com.acme.stonks.resource.AccountTermDepositResource;
import com.acme.stonks.resource.SaveAccountTermDepositResource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountTermDepositController {
    
    @Autowired
    private AccountTermDepositService accountTermDepositService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/board/{boardId}/accounts")
    public Page<AccountTermDepositResource> getAllAccountTermDepositsByBoardId(
    @PathVariable (value = "boardId") Long boardId,
    Pageable pageable) {

        Page<AccountTermDeposit> accountsPage = accountTermDepositService.getAllAccountTermDepositsByBoardId(boardId, pageable);

        List<AccountTermDepositResource> resources = accountsPage
            .getContent().stream().map(this::convertToResource)
            .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/account/{accountId}")
    public AccountTermDepositResource getAccountbyId(@PathVariable(value = "accountId") Long accountId) {
        return convertToResource(accountTermDepositService.getAccountTermDepositById(accountId).get());
    }

    @PostMapping("/board/{boardId}/account")
    public AccountTermDepositResource createAccount(@PathVariable(name = "boardId") Long boardId,
    @RequestParam(name = "bank") Long bankId, @Valid @RequestBody SaveAccountTermDepositResource resource){
        return convertToResource(accountTermDepositService
        .createAccountTermDeposit(boardId, bankId, convertToEntity(resource)));
    }

    @PutMapping("/account/{accountId}")
    public AccountTermDepositResource updateAccount(@PathVariable(name = "accountId") Long accountId,
    @Valid @RequestBody SaveAccountTermDepositResource resource){
        AccountTermDeposit account = convertToEntity(resource);
        return convertToResource(accountTermDepositService.updateAccountTermDeposit(accountId, account));
    }

    @DeleteMapping("/account/{accountId}")
    public ResponseEntity<?> deleteAccount(@PathVariable(name = "accountId") Long accountId) {
        return accountTermDepositService.deleteAccountTermDeposit(accountId);
    }

    @GetMapping("/board/{boardId}/accounts/intereses")
    public Page<AccountTermDepositResource> calcularInteresesProcedure(@PathVariable(value="boardId") Long boardId, Pageable pageable){
    	Page<AccountTermDeposit> list=accountTermDepositService.calcularInteresesProcedure(boardId,pageable);
    	List<AccountTermDepositResource> resources = list
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }
    
    // Converts
    private AccountTermDeposit convertToEntity(SaveAccountTermDepositResource resource) {
        return mapper.map(resource, AccountTermDeposit.class);
    }
    

    private AccountTermDepositResource convertToResource(AccountTermDeposit entity) {
        return mapper.map(entity, AccountTermDepositResource.class);
    }
    
    /*@GetMapping("/board/{boardId}/procedure")
    public ResponseEntity<List<AccountTermDeposit>> findAccountTermDepositsByBoardId(@PathVariable("boardId") Long boardId){
    	List<AccountTermDeposit> list=accountTermDepositService.findAccountTermDepositsByBoardId(boardId);
    	return new ResponseEntity<List<AccountTermDeposit>>(list,HttpStatus.OK);
    }*/
}
