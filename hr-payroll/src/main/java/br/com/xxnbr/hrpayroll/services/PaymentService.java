package br.com.xxnbr.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xxnbr.hrpayroll.entitites.Payment;

@Service
public class PaymentService {

  @Autowired
  private WorkerFeignClient feignClient;

  public Payment getPayment(long workerId, int days) {
    var worker = feignClient.findById(workerId).getBody();

    if (null == worker)
      throw new IllegalArgumentException("Worker ID invalid!");

    return Payment.builder()
        .name(worker.getName())
        .dailyIncome(worker.getDailyIncome())
        .days(days)
        .build();

  }
}
