package br.com.xxnbr.hrpayroll.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.xxnbr.hrpayroll.entitites.Payment;

@Service
public class PaymentService {

  public Payment getPayment(long workerId, int days) {
    return Payment.builder()
        .name("Bruno")
        .dailyIncome(BigDecimal.valueOf(324.475))
        .days(7)
        .build();
  }
}
