package com.acme.stonks.domain.repository;

import com.acme.stonks.domain.model.AccountTermDeposit;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface AccountTermDepositRepository extends JpaRepository<AccountTermDeposit, Long>{
    
    
    Page<AccountTermDeposit> findAllByBoardId(Long boardId, Pageable pageable);
    
    //@Query(value="CALL new_procedure(:idboard);", nativeQuery = true)
    @Procedure(procedureName = "NEW_PROCEDURE")
    Page<AccountTermDeposit> calcularInteresesProcedure(@Param("idboard") Long idboard,Pageable pageable);
    
    @Query(value="{call new_procedure(:idboard)}",nativeQuery = true)
    List<AccountTermDeposit> findAccountTermDepositsByBoardId(@Param("idboard") Long idboard);
}
