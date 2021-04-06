package com.shariful.mb.reportservice.services.implementations;
import com.shariful.mb.reportservice.entities.dtos.Transaction;
import com.shariful.mb.reportservice.services.interfaces.BalanceInterface;
import com.shariful.mb.reportservice.services.interfaces.TransactionInterface;
import com.shariful.mb.reportservice.entities.rabbitmq.TransactionMap;
import com.shariful.mb.reportservice.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionService implements TransactionInterface {
    private final TransactionRepository transactionRepository;
    private final BalanceInterface balanceService;

    public TransactionService(TransactionRepository transactionRepository, BalanceInterface balanceService) {
        this.transactionRepository = transactionRepository;
        this.balanceService = balanceService;
    }

    @Transactional
    @Override
    public void createTransaction(
            TransactionMap transactionCreationInfo
    ) {
        balanceService.saveBalance(transactionCreationInfo.getBalance());
        transactionRepository.save(transactionCreationInfo.getTransaction());
    }

    @Override
    public List<Transaction> findByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

}
