package br.com.xxnbr.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xxnbr.hruser.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
