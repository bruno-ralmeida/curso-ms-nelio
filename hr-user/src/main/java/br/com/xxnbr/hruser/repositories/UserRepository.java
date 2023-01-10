package br.com.xxnbr.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xxnbr.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);

}
