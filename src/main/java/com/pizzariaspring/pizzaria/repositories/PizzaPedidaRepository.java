package com.pizzariaspring.pizzaria.repositories;

import com.pizzariaspring.pizzaria.models.PizzaPedida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaPedidaRepository extends JpaRepository<PizzaPedida, Long> {
}
