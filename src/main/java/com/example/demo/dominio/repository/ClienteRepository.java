package com.example.demo.dominio.repository;

import com.example.demo.dominio.entity.Cliente;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
}
