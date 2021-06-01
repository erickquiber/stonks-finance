package com.acme.stonks.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.acme.stonks.domain.model.Transaction;
import com.acme.stonks.domain.service.TransactionService;
import com.acme.stonks.resource.TransactionResource;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name="Transaction",description = "Transaction API")
@RestController
@RequestMapping("/api")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/account/{accountId}/transactions")
    public Page<TransactionResource> getAllTransactionsByAccountTermDepositId(
            @PathVariable (value = "accountId") Long accountId,
            Pageable pageable) {
        Page<Transaction> transactionPage = transactionService.getAllTransactionsByAccountTremDepositId(accountId, pageable);
        List<TransactionResource> resources = transactionPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/board/{boardId}/transactions")
    public Page<TransactionResource> getAllTransactionsByBoardId(
            @PathVariable (value = "boardId") Long boardId,
            Pageable pageable) {
        Page<Transaction> transactionPage = transactionService.findByBoardId(boardId, pageable);
        List<TransactionResource> resources = transactionPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }


    // Converts
    /*
    private Transaction convertToEntity(SaveTransactionResource resource) {
        return mapper.map(resource, Transaction.class);
    }
    */

    private TransactionResource convertToResource(Transaction entity) {
        return mapper.map(entity, TransactionResource.class);
    }
}
