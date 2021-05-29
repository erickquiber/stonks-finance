package com.acme.stonks.service;

import com.acme.stonks.domain.model.Transaction;
import com.acme.stonks.domain.repository.TransactionRepository;
import com.acme.stonks.domain.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Page<Transaction> getAllTransactionsByAccountTremDepositId(Long accountTermDepositId, Pageable pageable) {
        return transactionRepository.findByAccountTermDepositId(accountTermDepositId, pageable);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public ResponseEntity<?> deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);;
        return ResponseEntity.ok().build();
    }

    @Override
    public Page<Transaction> findByBoardId(Long boardId, Pageable pageable) {
        return transactionRepository.findByBoardId(boardId, pageable);
    }
    
}
