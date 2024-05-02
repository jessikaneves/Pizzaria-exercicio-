package com.pizzariaspring.pizzaria.controllers;

import com.pizzariaspring.pizzaria.models.Cliente;
import com.pizzariaspring.pizzaria.repositories.ClienteRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(value = "/cadcliente", method = RequestMethod.POST)
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    @RequestMapping(value = "/mostracliente", method = RequestMethod.GET)
    public List<Cliente> findAll() {
        List<Cliente> clientes = this.clienteRepository.findAll();
        return clientes;
    }
    @RequestMapping(value = "/mostracliente/{id}", method = RequestMethod.GET)
    public Cliente findById(@PathVariable Long id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);

        if (cliente.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado");
        }else {
            return cliente.get();
        }
    }

    @RequestMapping(value = "/excluircliente/{id}", method = RequestMethod.DELETE)
    public Cliente deletarById (@PathVariable Long id){
        Cliente cliente = findById(id);
        this.clienteRepository.delete(cliente);
        return cliente;
    }

    @RequestMapping(value = "/editarcliente/{id}", method = RequestMethod.PUT)
    public Cliente updateById(@PathVariable Long id, @RequestBody Cliente cliente) {
        this.findById(id);
        cliente.setId(id);
        cliente = this.clienteRepository.save(cliente);
        return cliente;

    }
}
