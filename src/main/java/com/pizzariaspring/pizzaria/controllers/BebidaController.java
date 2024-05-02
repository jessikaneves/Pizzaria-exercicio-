package com.pizzariaspring.pizzaria.controllers;


import com.pizzariaspring.pizzaria.models.Bebida;
import com.pizzariaspring.pizzaria.repositories.BebidaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BebidaController {

    @Autowired
    private BebidaRepository bebidaRepository;

    @RequestMapping(value = "/cadbebida", method = RequestMethod.POST)
    public Bebida cadastrarBebida(@RequestBody Bebida bebida) {
        return bebidaRepository.save(bebida);
    }
    @RequestMapping(value = "/mostrabebida", method = RequestMethod.GET)
    public List<Bebida> findAll() {
        List<Bebida> bebidas = this.bebidaRepository.findAll();
        return bebidas;
    }
    @RequestMapping(value = "/mostrabebida/{id}", method = RequestMethod.GET)
    public Bebida findById(@PathVariable Long id) {
        Optional<Bebida> bebida = this.bebidaRepository.findById(id);

        if (bebida.isEmpty()) {
            throw new RuntimeException("Bebida não encontrado");
        }else {
            return bebida.get();
        }
    }

    @RequestMapping(value = "/excluirbebida/{id}", method = RequestMethod.DELETE)
    public Bebida deletarBebidaById (@PathVariable Long id){
        Bebida bebida = findById(id);
        this.bebidaRepository.delete(bebida);
        return bebida;
    }

    @RequestMapping(value = "/editarbebida/{id}", method = RequestMethod.PUT)
    public Bebida updateById(@PathVariable Long id, @RequestBody Bebida bebida) {
        this.findById(id);
        bebida.setId(id);
        bebida = this.bebidaRepository.save(bebida);
        return bebida;

    }
}
