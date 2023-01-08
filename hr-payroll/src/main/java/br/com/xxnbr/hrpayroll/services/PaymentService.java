package br.com.xxnbr.hrpayroll.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.xxnbr.hrpayroll.entitites.Payment;
import br.com.xxnbr.hrpayroll.entitites.Worker;

@Service
public class PaymentService {

  @Value("${hr-worker.host}")
  private String host;

  @Autowired
  private RestTemplate restTemplate;

  public Payment getPayment(long workerId, int days) {
    var url = host.concat("/workers/{id}");

    var worker = restTemplate.getForObject(url, Worker.class, workerId);

    if (null == worker)
      throw new IllegalArgumentException("Worker id invalid!");

    return Payment.builder()
        .name(worker.getName())
        .dailyIncome(worker.getDailyIncome())
        .days(days)
        .build();
  }
}
