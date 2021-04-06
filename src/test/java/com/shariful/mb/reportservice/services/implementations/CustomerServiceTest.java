package com.shariful.mb.reportservice.services.implementations;

import com.shariful.mb.reportservice.entities.dtos.Account;
import com.shariful.mb.reportservice.entities.dtos.Balance;
import com.shariful.mb.reportservice.entities.dtos.Customer;
import com.shariful.mb.reportservice.repositories.AccountRepository;
import com.shariful.mb.reportservice.repositories.BalanceRepository;
import com.shariful.mb.reportservice.repositories.CustomerRepository;
import com.shariful.mb.reportservice.services.interfaces.CustomerInterface;
import com.shariful.mb.reportservice.entities.rabbitmq.AccountMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public
class CustomerServiceTest {

    @Autowired
    CustomerInterface customerInterface;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BalanceRepository balanceRepository;

    @Test
    void createCustomer() {
        AccountMap accountMap =
                AccountMap.builder()
                        .customer(Customer.builder()
                                .country("Estonia")
                                .customerId(1L)
                                .build())
                        .account(Account.builder()
                                .customerId(1L)
                                .accountId(1L)
                                .build())
                        .balances(Arrays.asList(Balance.builder()
                                .balanceId(1L)
                                .accountId(1L)
                                .currency("EUR")
                                .balance(BigDecimal.valueOf(50L))
                                .build()))
                        .build();
        customerInterface.createCustomer(accountMap);
        Optional<Customer> insertedCustomer = customerRepository.findById(1L);
        Account insertedAccount = accountRepository.findByAccountId(1L);
        List<Balance> insertedBalances = balanceRepository.findByAccountId(1L);
        assertEquals(accountMap.getAccount().getAccountId(), insertedAccount.getAccountId());
        assertEquals(accountMap.getCustomer().getCustomerId(), insertedCustomer.get().getCustomerId());
        assertEquals(accountMap.getBalances().get(0).getCurrency(), insertedBalances.get(0).getCurrency());
    }
}
