package com.angelina.productregistration.service;

import com.angelina.productregistration.model.Produto;
import com.angelina.productregistration.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

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
