package com.shariful.mb.reportservice.services.interfaces;



import com.shariful.mb.reportservice.entities.dtos.Balance;

import java.util.List;

public interface BalanceInterface {
    Balance saveBalance(Balance balance);

    List<Balance> saveBalance(List<Balance> balance);

    List<Balance> findByAccountId(Long accountId);
}
