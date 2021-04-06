package com.shariful.mb.reportservice.services.implementations;

import com.shariful.mb.reportservice.entities.dtos.Balance;
import com.shariful.mb.reportservice.repositories.BalanceRepository;
import com.shariful.mb.reportservice.services.interfaces.BalanceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BalanceService implements BalanceInterface {
    private final BalanceRepository balanceRepository;

    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Override
    public Balance saveBalance(Balance balance) {
        return balanceRepository.save(balance);
    }

    @Override
    public List<Balance> saveBalance(List<Balance> balances) {
        return StreamSupport.stream(
                balanceRepository.saveAll(balances).spliterator(),
                false
        ).collect(Collectors.toList());
    }

    @Override
    public List<Balance> findByAccountId(Long accountId) {
        return balanceRepository.findByAccountId(accountId);
    }
}
