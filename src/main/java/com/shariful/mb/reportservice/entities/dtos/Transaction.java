package com.shariful.mb.reportservice.entities.dtos;
import com.shariful.mb.reportservice.utilities.util.DirectionOfTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    private Long transactionId;
    private Long accountId;
    private BigDecimal amount;
    private String currency;
    @Enumerated(value = EnumType.STRING)
    private DirectionOfTransaction directionOfTransaction;
    private String description;
}
