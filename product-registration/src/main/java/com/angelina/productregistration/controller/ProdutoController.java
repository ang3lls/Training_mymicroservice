package com.angelina.productregistration.controller;

import com.angelina.productregistration.model.Produto;
import com.angelina.productregistration.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/save")
    public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.gravarProduto(produto));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Produto> findProduto(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(produtoService.buscarProdutoPeloID(id));
    }

    @GetMapping("/find-all")
    public List<Produto> findAllProdutos(){
        return produtoService.buscarTodosProdutos();
    }

}
