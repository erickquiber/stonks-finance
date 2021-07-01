package com.acme.stonks.service;

import java.util.Date;
import java.util.Optional;

import com.acme.stonks.domain.model.AccountTermDeposit;
import com.acme.stonks.domain.model.Bank;
import com.acme.stonks.domain.model.Board;
import com.acme.stonks.domain.model.Transaction;
import com.acme.stonks.domain.repository.AccountTermDepositRepository;
import com.acme.stonks.domain.repository.BankRepository;
import com.acme.stonks.domain.repository.BoardRepository;
import com.acme.stonks.domain.repository.TransactionRepository;
import com.acme.stonks.domain.service.AccountTermDepositService;
import com.acme.stonks.util.CompoundInterest;

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

    @Autowired
    private TransactionRepository transactionRepository;

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

        accountTermDepositRepository.save(accountTermDeposit
        .setBank(bank).setBoard(board));
        
        createTransactionsByAccount(accountTermDeposit);

        return accountTermDeposit;
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
        .setMonthlyPayment(accountDetails.isMonthlyPayment())
        .setWithdrawalInterest(accountDetails.isWithdrawalInterest()));
    }

    @Override
    public ResponseEntity<?> deleteAccountTermDeposit(Long accountId) {
        AccountTermDeposit post = accountTermDepositRepository.findById(accountId).orElseThrow();
        accountTermDepositRepository.delete(post);
        return ResponseEntity.ok().build();
    }


    public void createTransactionsByAccount(AccountTermDeposit account){
        long days = CompoundInterest.daysDifference(account.getDateStart(), account.getDateEnd());

        double months = (double)days/30;
        months = months - months % 1;

        Date date = account.getDateStart();

        double cap = account.getCapital();
        double tem = CompoundInterest.teaToTem(account.getTea());
        double amount = 0.0d;

        for (int i = 0; i < months; i++) {
            
            Transaction transaction = new Transaction();

            amount = cap*tem;
            cap = cap+amount;
            date = CompoundInterest.addDaysToDate(date, 30);

            transaction.setType("Pago de Interes")
            .setAccountTermDeposit(account)
            .setAmount(amount)
            .setDate(date)
            .setCurrentCapital(cap);

            transactionRepository.save(transaction);
        } 
    }

    /*
	@Override
	public Page<AccountTermDeposit> calcularInteresesProcedure(Long accountId, Pageable pageable) {
		return accountTermDepositRepository.calcularInteresesProcedure(accountId,pageable);
	}*/

	/*@Override
	public List<AccountTermDeposit> findAccountTermDepositsByBoardId(Long boardId) {
		return accountTermDepositRepository.findAccountTermDepositsByBoardId(boardId);
	}*/

}
