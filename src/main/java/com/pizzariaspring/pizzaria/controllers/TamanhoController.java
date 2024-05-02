package com.pizzariaspring.pizzaria.controllers;


import com.pizzariaspring.pizzaria.models.Tamanho;
import com.pizzariaspring.pizzaria.repositories.TamanhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class TamanhoController {

    @Autowired
    private TamanhoRepository tamanhoRepository;

    @RequestMapping(value = "/cadtamanho", method = RequestMethod.POST)
    public Tamanho cadastrarCliente(@RequestBody Tamanho tamanho) {
        return tamanhoRepository.save(tamanho);
    }
    @RequestMapping(value = "/mostratamanho", method = RequestMethod.GET)
    public List<Tamanho> findAll() {
        List<Tamanho> tamanhos = this.tamanhoRepository.findAll();
        return tamanhos;
    }
    @RequestMapping(value = "/mostratamanho/{id}", method = RequestMethod.GET)
    public Tamanho findById(@PathVariable Long id) {
        Optional<Tamanho> usuario = this.tamanhoRepository.findById(id);

        if (usuario.isEmpty()) {
            throw new RuntimeException("Tamanho não encontrado");
        }else {
            return usuario.get();
        }
    }

    @RequestMapping(value = "/excluirtamanho/{id}", method = RequestMethod.DELETE)
    public Tamanho deletarById (@PathVariable Long id){
        Tamanho tamanho = findById(id);
        this.tamanhoRepository.delete(tamanho);
        return tamanho;
    }

    @RequestMapping(value = "/editartamanho/{id}", method = RequestMethod.PUT)
    public Tamanho updateById(@PathVariable Long id, @RequestBody Tamanho tamanho) {
        this.findById(id);
        tamanho.setId(id);
        tamanho = this.tamanhoRepository.save(tamanho);
        return tamanho;

    }
}
