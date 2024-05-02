package com.pizzariaspring.pizzaria.repositories;

import com.pizzariaspring.pizzaria.models.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebidaRepository extends JpaRepository<Bebida, Long> {
}
