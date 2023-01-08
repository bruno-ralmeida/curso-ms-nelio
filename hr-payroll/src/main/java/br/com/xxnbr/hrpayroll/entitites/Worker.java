package br.com.xxnbr.hrpayroll.entitites;

import java.io.Serializable;
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
public class Worker implements Serializable {

  private Long id;
  private String name;
  private BigDecimal dailyIncome;

}
