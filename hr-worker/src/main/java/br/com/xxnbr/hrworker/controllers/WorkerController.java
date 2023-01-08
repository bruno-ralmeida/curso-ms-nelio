package br.com.xxnbr.hrworker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private WorkerRepository repository;

  @GetMapping
  public ResponseEntity<List<Worker>> findAll() {
    var result = repository.findAll();

    return ResponseEntity.ok().body(result);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Worker> findById(@PathVariable Long id) {
    var result = repository.findById(id);

    if (result.isEmpty())
      return ResponseEntity.notFound().build();

    return ResponseEntity.ok().body(result.get());
  }
}
