package com.acme.stonks.domain.service;

import java.util.Optional;

import com.acme.stonks.domain.model.AccountTermDeposit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface AccountTermDepositService {
    Page<AccountTermDeposit> getAllAccountTermDepositsByBoardId(Long boardId,Pageable pageable);
    Optional<AccountTermDeposit> getAccountTermDepositById(Long accountId);
    AccountTermDeposit createAccountTermDeposit(Long boardId, Long bankId, AccountTermDeposit accountTermDeposit);
    AccountTermDeposit updateAccountTermDeposit(Long accountId, AccountTermDeposit accountDetails);
    ResponseEntity<?> deleteAccountTermDeposit(Long accountId);
    //Page<AccountTermDeposit> calcularInteresesProcedure(Long boardId, Pageable pageable);
    //List<AccountTermDeposit> findAccountTermDepositsByBoardId(Long boardId);
}
