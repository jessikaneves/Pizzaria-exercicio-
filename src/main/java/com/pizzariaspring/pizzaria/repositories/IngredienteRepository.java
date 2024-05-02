package com.pizzariaspring.pizzaria.repositories;

import com.pizzariaspring.pizzaria.models.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingredientes, Long> {
}
