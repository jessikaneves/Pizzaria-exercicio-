package com.pizzariaspring.pizzaria.repositories;

import com.pizzariaspring.pizzaria.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
