package com.shariful.mb.reportservice.entities.rabbitmq;

import com.shariful.mb.reportservice.entities.dtos.Account;
import com.shariful.mb.reportservice.entities.dtos.Balance;
import com.shariful.mb.reportservice.entities.dtos.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountMap {
    private Customer customer;
    private Account account;
    private List<Balance> balances;
}
