package com.angelina.productregistration.service;

import com.angelina.productregistration.model.Produto;
import com.angelina.productregistration.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto gravarProduto(Produto produto){
        Produto novoProduto = new Produto();
        novoProduto.setDescricao(produto.getDescricao());
        novoProduto.setValorUnitario(produto.getValorUnitario());
        return produtoRepository.save(novoProduto);
    }

    public Produto buscarProdutoPeloID(int id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            return new Produto();
        }
        return produto.get();
    }

    public List<Produto> buscarTodosProdutos(){
        return produtoRepository.findAll();
    }
}
