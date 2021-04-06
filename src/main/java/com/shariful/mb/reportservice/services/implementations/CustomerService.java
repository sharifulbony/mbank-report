package com.shariful.mb.reportservice.services.implementations;
import com.shariful.mb.reportservice.repositories.CustomerRepository;
import com.shariful.mb.reportservice.services.interfaces.AccountInterface;
import com.shariful.mb.reportservice.services.interfaces.BalanceInterface;
import com.shariful.mb.reportservice.entities.rabbitmq.AccountMap;
import com.shariful.mb.reportservice.services.interfaces.CustomerInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService implements CustomerInterface {
    CustomerRepository customerRepository;
    private final AccountInterface accountInterface;
    private final BalanceInterface balanceService;

    public CustomerService(
            CustomerRepository customerRepository,
            AccountInterface accountInterface,
            BalanceInterface balanceService
    ) {
        this.customerRepository = customerRepository;
        this.accountInterface = accountInterface;
        this.balanceService = balanceService;
    }

    @Transactional
    @Override
    public void createCustomer(AccountMap accountMap) {
        customerRepository.save(accountMap.getCustomer());
        accountInterface.createAccount(accountMap.getAccount());
        balanceService.saveBalance(accountMap.getBalances());
    }
}
