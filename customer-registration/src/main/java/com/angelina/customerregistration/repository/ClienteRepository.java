package com.angelina.customerregistration.repository;

import com.angelina.customerregistration.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
