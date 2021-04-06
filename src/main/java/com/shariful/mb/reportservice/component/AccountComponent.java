package com.shariful.mb.reportservice.component;
import com.shariful.mb.reportservice.entities.rabbitmq.AccountMap;
import com.shariful.mb.reportservice.services.implementations.CustomerService;
import com.shariful.mb.reportservice.utilities.config.Constant;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountComponent {
    private final CustomerService customerService;

    @RabbitListener(queues = Constant.ACCOUNT_KEY)
    public void createAccount(
            AccountMap accountMap
    ) {
        customerService.createCustomer(accountMap);
    }

}
