package com.acme.stonks.domain.service;

import com.acme.stonks.domain.model.Transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TransactionService {
    Page<Transaction> getAllTransactionsByAccountTremDepositId(Long accountTermDepositId,Pageable pageable);
    Page<Transaction> findByBoardId(Long boardId,Pageable pageable);
    Transaction createTransaction(Transaction transaction);
    ResponseEntity<?> deleteTransaction(Long transactionId);
}
