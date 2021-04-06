package com.shariful.mb.reportservice.services.implementations;
import com.shariful.mb.reportservice.entities.dtos.Account;
import com.shariful.mb.reportservice.services.interfaces.AccountInterface;
import com.shariful.mb.reportservice.repositories.AccountRepository;
import com.shariful.mb.reportservice.utilities.config.Constant;
import com.shariful.mb.reportservice.utilities.exception.PersistenceException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountInterface {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findByAccountId(Long accountId) throws PersistenceException {
        var account = accountRepository.findByAccountId(accountId);
        if (account == null)
            throw new PersistenceException(Constant.ACCOUNT_NOT_FOUND);
        return account;
    }
}
