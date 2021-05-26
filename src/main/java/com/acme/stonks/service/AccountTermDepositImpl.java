package com.acme.stonks.service;

import java.util.Optional;

import com.acme.stonks.domain.model.AccountTermDeposit;
import com.acme.stonks.domain.model.Bank;
import com.acme.stonks.domain.model.Board;
import com.acme.stonks.domain.repository.AccountTermDepositRepository;
import com.acme.stonks.domain.repository.BankRepository;
import com.acme.stonks.domain.repository.BoardRepository;
import com.acme.stonks.domain.service.AccountTermDepositService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountTermDepositImpl implements AccountTermDepositService {

    @Autowired
    private AccountTermDepositRepository accountTermDepositRepository;

    @Autowired
    private BankRepository bankRepository;
    
    
    @Autowired
    private BoardRepository boardRepository;

 

    @Override
    public Page<AccountTermDeposit> getAllAccountTermDepositsByBoardId(Long boardId, Pageable pageable) {
        return accountTermDepositRepository.findAllByBoardId(boardId, pageable);
    }

    @Override
    public Optional<AccountTermDeposit> getAccountTermDepositById(Long accountId) {
        return accountTermDepositRepository.findById(accountId);
    }

    @Override
    public AccountTermDeposit createAccountTermDeposit(Long boardId, Long bankId, AccountTermDeposit accountTermDeposit) {

        Bank bank = bankRepository.findById(bankId).orElseThrow();
        Board board = boardRepository.findById(boardId).orElseThrow();

        return accountTermDepositRepository.save(accountTermDeposit
        .setBank(bank).setBoard(board));
        //Agregar board cuando se implemente
    }

    @Override
    public AccountTermDeposit updateAccountTermDeposit(Long accountId, AccountTermDeposit accountDetails) {
        AccountTermDeposit account = accountTermDepositRepository.findById(accountId).get();
        return accountTermDepositRepository.save(account
        .setCapital(accountDetails.getCapital())
        .setTea(accountDetails.getTea())
        .setMinTea(accountDetails.getMinTea())
        .setDateEnd(accountDetails.getDateEnd())
        .setDateStart(accountDetails.getDateStart())
        .setInterestPaymentType(accountDetails.isInterestPaymentType())
        .setWithdrawalInterest(accountDetails.isWithdrawalInterest()));
    }

    @Override
    public ResponseEntity<?> deleteAccountTermDeposit(Long accountId) {
        AccountTermDeposit post = accountTermDepositRepository.findById(accountId).orElseThrow();
        accountTermDepositRepository.delete(post);
        return ResponseEntity.ok().build();
    }

    
}
