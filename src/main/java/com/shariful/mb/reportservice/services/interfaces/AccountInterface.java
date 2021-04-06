package com.shariful.mb.reportservice.services.interfaces;
import com.shariful.mb.reportservice.entities.dtos.Account;
import com.shariful.mb.reportservice.utilities.exception.PersistenceException;

public interface AccountInterface {
    Account createAccount(Account account);
    Account findByAccountId(Long accountId) throws PersistenceException;
}
