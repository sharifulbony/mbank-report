package com.shariful.mb.reportservice.repositories;
import com.shariful.mb.reportservice.entities.dtos.Balance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BalanceRepository extends CrudRepository<Balance, Long> {
    List<Balance> findByAccountId(Long accountId);

    Balance findByAccountIdAndCurrency(Long accountId, String currency);
}
