package br.com.xxnbr.hrworker.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xxnbr.hrworker.entities.Worker;
import br.com.xxnbr.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

  private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

  @Autowired
  private Environment env;

  @Autowired
  private WorkerRepository repository;

  @GetMapping
  public ResponseEntity<List<Worker>> findAll() {
    var result = repository.findAll();

    return ResponseEntity.ok().body(result);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Worker> findById(@PathVariable Long id) {
    var msg = String.format("PORT = %s", env.getProperty("local.server.port"));

    logger.info(msg);

    var result = repository.findById(id);

    if (result.isEmpty())
      return ResponseEntity.notFound().build();

    return ResponseEntity.ok().body(result.get());
  }
}
