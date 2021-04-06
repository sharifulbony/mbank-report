package com.shariful.mb.reportservice.repositories;
import com.shariful.mb.reportservice.entities.dtos.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByAccountId(Long accountId);
}
