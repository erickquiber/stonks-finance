package com.acme.stonks.domain.repository;

import com.acme.stonks.domain.model.Transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    Page<Transaction> findByAccountTermDepositId(Long accountTermDepositId, Pageable pageable);
/*
SELECT t.* FROM boards b
inner join stonksdb.account_term_deposits atd on atd.board_id=b.id
inner join transactions t on t.account_term_deposit_id=atd.id
where b.id=3
*/
    @Query("select t from Board b inner join b.accounts a inner join a.transactions t where b.id = ?1")
    Page<Transaction> findByBoardId(Long boardId, Pageable pageable);

}
