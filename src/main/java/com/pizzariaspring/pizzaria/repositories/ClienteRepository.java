package com.pizzariaspring.pizzaria.repositories;

import com.pizzariaspring.pizzaria.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
