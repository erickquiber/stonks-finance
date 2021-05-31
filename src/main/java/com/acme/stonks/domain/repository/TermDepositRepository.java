package com.acme.stonks.domain.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.acme.stonks.domain.model.TermDeposit;

public interface TermDepositRepository extends JpaRepository<TermDeposit, Long>{
	Page<TermDeposit> findByBankId(Long bankId, Pageable pageable);
	Optional<TermDeposit> findByIdAndBankId(Long id, Long bankid);
	@Query(value="SELECT t.* FROM termdeposit t where t.currency=?3 and t.min_amount<=?1 and t.min_day<=?2",nativeQuery = true)
	List<TermDeposit> getAllComparison(float amount, Integer days, String currency);
}
