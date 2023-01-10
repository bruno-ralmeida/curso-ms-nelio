package br.com.xxnbr.hroauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.xxnbr.hroauth.entities.User;
import br.com.xxnbr.hroauth.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping(value = "/search")
  public ResponseEntity<User> findByEmail(@RequestParam String email) {
    try {
      var response = service.findByEmail(email);
      return ResponseEntity.ok(response);

    } catch (IllegalArgumentException e) {
      return ResponseEntity.notFound().build();
    }

  }

}
