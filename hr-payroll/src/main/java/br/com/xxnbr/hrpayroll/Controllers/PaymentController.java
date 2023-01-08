package br.com.xxnbr.hrpayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xxnbr.hrpayroll.entitites.Payment;
import br.com.xxnbr.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

  @Autowired
  private PaymentService service;

  @GetMapping(value = "/{workerId}/days/{days}")
  public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
    var payment = service.getPayment(workerId, days);

    return ResponseEntity.ok().body(payment);
  }

}
