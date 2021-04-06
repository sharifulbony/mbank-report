package com.shariful.mb.reportservice.services.interfaces;



import com.shariful.mb.reportservice.entities.rabbitmq.AccountMap;

public interface CustomerInterface {
    void createCustomer(AccountMap accountMap);
}
