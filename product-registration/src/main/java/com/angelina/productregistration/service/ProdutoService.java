package com.angelina.productregistration.service;

import com.angelina.productregistration.model.Produto;
import com.angelina.productregistration.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto gravarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto buscarProdutoPeloID(int id){
        return produtoRepository.getOne(id);
    }

    public List<Produto> buscarTodosProdutos(){
        return produtoRepository.findAll();
    }
}
