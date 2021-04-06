package com.shariful.mb.reportservice.services.implementations;

import com.shariful.mb.reportservice.entities.dtos.Account;
import com.shariful.mb.reportservice.entities.dtos.Balance;
import com.shariful.mb.reportservice.entities.dtos.Transaction;
import com.shariful.mb.reportservice.repositories.AccountRepository;
import com.shariful.mb.reportservice.repositories.BalanceRepository;
import com.shariful.mb.reportservice.repositories.CustomerRepository;
import com.shariful.mb.reportservice.services.interfaces.CustomerInterface;
import com.shariful.mb.reportservice.services.interfaces.TransactionInterface;
import com.shariful.mb.reportservice.utilities.util.DirectionOfTransaction;
import com.shariful.mb.reportservice.entities.rabbitmq.TransactionMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionServiceTest {

    @Autowired
    CustomerInterface customerInterface;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BalanceRepository balanceRepository;

    @Autowired
    TransactionInterface transactionInterface;

    @Test
    void createTransaction() {

        TransactionMap transactionCreationInfo =
                TransactionMap.builder()
                        .balance(Balance.builder()
                                .balanceId(1L)
                                .accountId(1L)
                                .currency("EUR")
                                .balance(BigDecimal.valueOf(50L))
                                .build())
                        .transaction(Transaction.builder()
                                .transactionId(1L)
                                .accountId(1L)
                                .amount(BigDecimal.valueOf(50L))
                                .currency("EUR")
                                .directionOfTransaction(DirectionOfTransaction.IN)
                                .description("Cash In")
                                .build())
                        .build();
        transactionInterface.createTransaction(transactionCreationInfo);
        Account insertedAccount = accountRepository.findByAccountId(1L);
        List<Transaction> transactions = transactionInterface.findByAccountId(1L);
        List<Balance> balances = balanceRepository.findByAccountId(1L);
        assertEquals(insertedAccount.getAccountId(), 1L);
        assertEquals(balances.get(0).getCurrency(), "EUR");
        assertEquals(transactions.get(0).getCurrency(), "EUR");
    }
}
