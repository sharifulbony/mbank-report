package com.shariful.mb.reportservice.services.interfaces;



import com.shariful.mb.reportservice.entities.dtos.Transaction;
import com.shariful.mb.reportservice.entities.rabbitmq.TransactionMap;

import java.util.List;

public interface TransactionInterface {
    void createTransaction(TransactionMap transactionCreationInfo);
    List<Transaction> findByAccountId(Long accountId);

}
