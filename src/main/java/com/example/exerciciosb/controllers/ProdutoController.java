package com.example.exerciciosb.controllers;

import java.util.Optional;

import javax.validation.Valid;
import com.example.exerciciosb.model.entities.Produto;
import com.example.exerciciosb.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    /* Ele permite que o Spring resolva e 
    injete beans colaborativos em nosso bean.*/ 
    /**
     * A injeção de dependencia so pode
     *  existir em uma classe do Spring
     */
    @Autowired
    private ProdutoRepository produtoRepository;

   @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto saveProduto(@Valid Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    // Organiza os elementos em paginas
    @GetMapping(path = "/pagina/{numeroPagina}")
    public Iterable<Produto> obterProdutoPorPagina(@PathVariable int numeroPagina,
    @PathVariable int qtdPagina){
        PageRequest page = PageRequest.of(numeroPagina, 5);
        return produtoRepository.findAll(page);
    }

    @GetMapping
    public Iterable<Produto> obterProduto(){
        return produtoRepository.findAll();
    }
    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutoPorNome(@PathVariable String parteNome){
        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    }
    @GetMapping(path = "/nome2/{parteNome}")
    public Iterable<Produto> obterProdutoPorNome2(@PathVariable String parteNome){
        return produtoRepository.searchByNameLike(parteNome);
    }
    @GetMapping(path="/{id}")
    public Optional<Produto> obterProdutoId(@PathVariable int id){
        return produtoRepository.findById(id);
    }

    //@PutMapping
    //public Produto alterarProduto(@Valid Produto produto){
       // produtoRepository.save(produto);
     //   return produto;
   // }

   @DeleteMapping(path="/{id}")
   public void excluir(@PathVariable int id){
       produtoRepository.deleteById(id);
   }
}
