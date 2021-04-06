package com.shariful.mb.reportservice.entities.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Balance {
    @Id
    private Long balanceId;
    private Long accountId;
    private String currency;
    private BigDecimal balance;
}
