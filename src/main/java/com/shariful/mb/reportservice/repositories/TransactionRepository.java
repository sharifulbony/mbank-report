package com.shariful.mb.reportservice.repositories;
import com.shariful.mb.reportservice.entities.dtos.Transaction;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Long accountId);
}
