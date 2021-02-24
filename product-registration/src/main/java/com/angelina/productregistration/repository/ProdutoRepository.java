package com.angelina.productregistration.repository;

import com.angelina.productregistration.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
