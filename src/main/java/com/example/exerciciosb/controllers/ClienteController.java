package com.example.exerciciosb.controllers;

import com.example.exerciciosb.model.entities.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @GetMapping(path = "/qualquer")
    public Cliente obterCliente(){
        return new Cliente(28,"Pedro", "123.456.789-00");
    }

    @GetMapping("/{id}")
    public Cliente obterClientePorId1(@PathVariable int id){//PathVariable faz o valor ser alterado pela url
        return new Cliente(id, "Maria", "987.654.321-00");
    }
    @GetMapping
    public Cliente obterClientePorId2(@RequestParam(name = "id", defaultValue = "1") int id){//
        return new Cliente(id, "Agusto", "111.222.333-00");
    }


}
