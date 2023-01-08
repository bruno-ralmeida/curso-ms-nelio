package br.com.xxnbr.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xxnbr.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
