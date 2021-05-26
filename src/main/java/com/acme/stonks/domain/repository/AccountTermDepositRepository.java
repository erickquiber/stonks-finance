package com.acme.stonks.domain.repository;

import com.acme.stonks.domain.model.AccountTermDeposit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTermDepositRepository extends JpaRepository<AccountTermDeposit, Long>{
    
    
    Page<AccountTermDeposit> findAllByBoardId(Long boardId, Pageable pageable);
    
}
