package com.angelina.productregistration.templates;

import com.angelina.productregistration.dto.ProdutoDTO;

import java.util.Arrays;
import java.util.List;

public class ProductBuilder {
    public static ProdutoDTO getProduto(){
        return new ProdutoDTO(1,1,"Café Extraforte", 5.80f);
    }

    public static List<ProdutoDTO> getProdutos(){
        return Arrays.asList(
                new ProdutoDTO(1,1,"Café Extraforte", 5.80f),
                new ProdutoDTO(2, 2, "Cappuccino", 6f));
    }
}
