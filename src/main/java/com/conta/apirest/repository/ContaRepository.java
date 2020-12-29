package com.conta.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conta.apirest.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
	Conta findById(long id);
}
