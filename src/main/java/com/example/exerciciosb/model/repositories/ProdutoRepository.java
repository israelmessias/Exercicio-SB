package com.example.exerciciosb.model.repositories;

import com.example.exerciciosb.model.entities.Produto;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository 
extends PagingAndSortingRepository<Produto, Integer>{
    //CrudRepositoryimplementa operações básicas de CRUD,
    // incluindo contagem, exclusão, deleteById, salve, saveAll, findById e findAll.

    
    public Iterable <Produto> findByNomeContainingIgnoreCase(String parteNome);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE  %:nome%")
    public Iterable <Produto> searchByNameLike(@Param("nome") String nome);
}
