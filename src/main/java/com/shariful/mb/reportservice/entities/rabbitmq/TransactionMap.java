package com.shariful.mb.reportservice.entities.rabbitmq;
import com.shariful.mb.reportservice.entities.dtos.Balance;
import com.shariful.mb.reportservice.entities.dtos.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionMap {
    private Transaction transaction;
    private Balance balance;
}
