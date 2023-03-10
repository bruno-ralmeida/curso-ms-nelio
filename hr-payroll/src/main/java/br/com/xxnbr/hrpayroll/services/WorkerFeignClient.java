package br.com.xxnbr.hrpayroll.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.xxnbr.hrpayroll.entitites.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

  @GetMapping(value = "/{id}")
  public ResponseEntity<Worker> findById(@PathVariable Long id);

}
