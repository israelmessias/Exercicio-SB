package com.example.exerciciosb.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class FirstController {

    @GetMapping(path = {"/ola", "/saudação"})// URLS QUE CHAMAM O METODO ola, não se pode ter uma mesma url para varios metodos
    public String ola(){
        return "Ola Spring Boot!";
    }
}
