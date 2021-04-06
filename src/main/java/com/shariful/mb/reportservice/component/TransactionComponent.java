package com.shariful.mb.reportservice.component;
import com.shariful.mb.reportservice.services.interfaces.TransactionInterface;
import com.shariful.mb.reportservice.entities.rabbitmq.TransactionMap;
import com.shariful.mb.reportservice.utilities.config.Constant;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionComponent {
    private final TransactionInterface transactionInterface;

    @RabbitListener(queues = Constant.TRANSACTION_KEY)
    public void createTransaction(
            TransactionMap transactionCreationInfo
    ){
        transactionInterface.createTransaction(transactionCreationInfo);
    }
}
