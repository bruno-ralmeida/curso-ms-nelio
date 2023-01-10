package br.com.xxnbr.hruser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.xxnbr.hruser.entities.User;
import br.com.xxnbr.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private UserRepository repository;

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    var response = repository.findById(id);

    if (response.isEmpty())
      return ResponseEntity.notFound().build();

    return ResponseEntity.ok(response.get());
  }

  @GetMapping(value = "/search")
  public ResponseEntity<User> findByEmail(@RequestParam String email) {
    var response = repository.findByEmail(email);

    if (response.isEmpty())
      return ResponseEntity.notFound().build();

    return ResponseEntity.ok(response.get());
  }
}
