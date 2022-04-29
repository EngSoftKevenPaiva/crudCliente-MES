package com.example.demo.dominio.repository;

import com.example.demo.dominio.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
