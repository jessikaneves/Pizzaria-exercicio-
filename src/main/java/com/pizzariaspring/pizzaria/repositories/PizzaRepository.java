package com.pizzariaspring.pizzaria.repositories;

import com.pizzariaspring.pizzaria.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {
}
