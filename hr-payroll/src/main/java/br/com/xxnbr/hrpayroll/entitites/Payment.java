package br.com.xxnbr.hrpayroll.entitites;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

  private String name;
  private BigDecimal dailyIncome;
  private Integer days;

  public BigDecimal getTotal() {
    return dailyIncome.multiply(BigDecimal.valueOf(days));
  }
}
