package com.pizzariaspring.pizzaria.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pizzahasingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PizzaPedida pizzaPedida;

    @ManyToOne
    private Ingredientes ingredientes;

    public Pizzahasingrediente() {}

    public Pizzahasingrediente(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PizzaPedida getPizzaPedida() {
        return pizzaPedida;
    }

    public void setPizzaPedida(PizzaPedida pizzaPedida) {
        this.pizzaPedida = pizzaPedida;
    }

    public Ingredientes getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingredientes ingredientes) {
        this.ingredientes = ingredientes;
    }
}
