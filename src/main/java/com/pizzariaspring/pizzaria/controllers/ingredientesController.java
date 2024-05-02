package com.pizzariaspring.pizzaria.controllers;


import com.pizzariaspring.pizzaria.models.Ingredientes;
import com.pizzariaspring.pizzaria.repositories.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ingredientesController {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @RequestMapping(value = "/cadingrediente", method = RequestMethod.POST)
    public Ingredientes cadastrarIngrediente(@RequestBody Ingredientes ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }
    @RequestMapping(value = "/mostraingrediente", method = RequestMethod.GET)
    public List<Ingredientes> findAll() {
        List<Ingredientes> ingredientes = this.ingredienteRepository.findAll();
        return ingredientes;
    }
    @RequestMapping(value = "/mostraingrediente/{id}", method = RequestMethod.GET)
    public Ingredientes findById(@PathVariable Long id) {
        Optional<Ingredientes> ingrediente = this.ingredienteRepository.findById(id);

        if (ingrediente.isEmpty()) {
            throw new RuntimeException("ingrediente não encontrado");
        }else {
            return ingrediente.get();
        }
    }

    @RequestMapping(value = "/excluiringrediente/{id}", method = RequestMethod.DELETE)
    public Ingredientes deletarById (@PathVariable Long id){
        Ingredientes ingrediente = findById(id);
        this.ingredienteRepository.delete(ingrediente);
        return ingrediente;
    }

    @RequestMapping(value = "/editaringrediente/{id}", method = RequestMethod.PUT)
    public Ingredientes updateById(@PathVariable Long id, @RequestBody Ingredientes ingrediente) {
        this.findById(id);
        ingrediente.setId(id);
        ingrediente = this.ingredienteRepository.save(ingrediente);
        return ingrediente;

    }
}
