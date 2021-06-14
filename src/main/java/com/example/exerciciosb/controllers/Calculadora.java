package com.example.exerciciosb.controllers;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class Calculadora {
    //private int a, b;

    @GetMapping("/somar/{a}/{b}")
    public int somar(@PathVariable int a, @PathVariable int b){
        return a+b;
    }
    @GetMapping("/subtrair/{a}/{b}")
    public int subtrair(@PathVariable int a, @PathVariable int b){
        return a-b;
    }
}
