package com.angelina.salesregistration.repository;

import com.angelina.salesregistration.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
