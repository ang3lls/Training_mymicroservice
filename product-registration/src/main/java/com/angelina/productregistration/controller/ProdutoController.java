package com.angelina.productregistration.controller;

import com.angelina.productregistration.model.Produto;
import com.angelina.productregistration.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Product")
@RequestMapping("/Produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @ApiOperation(value = "Salvar produto")
    @PostMapping("/save")
    public ResponseEntity<Produto> saveProduto(@RequestBody @ApiParam(name = "Corpo",
            value = "Representação de um novo produto") Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.gravarProduto(produto));
    }

    @ApiOperation(value = "Buscar produto por id")
    @GetMapping("/id/{id}")
    public ResponseEntity<Produto> findProduto(@PathVariable @ApiParam (value =
            "Id de um produto", example = "1")int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(produtoService.buscarProdutoPeloID(id));
    }

    @ApiOperation(value = "Buscar por todos os produtos")
    @GetMapping("/find-all")
    public List<Produto> findAllProdutos(){
        return produtoService.buscarTodosProdutos();
    }

}
