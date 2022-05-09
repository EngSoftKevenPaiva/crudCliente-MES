package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.dominio.entity.Cliente;
import com.example.demo.dominio.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @PostMapping
    public Cliente create(@Valid @RequestBody Cliente cliente) {
        System.out.println(cliente);
        // cliente.getEndereco().setBairro(cliente.getEndereco().getBairro());
        return clienteRepository.save(cliente);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity getClient(@PathVariable Long id) {
        return clienteRepository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
    return clienteRepository.findById(id)
            .map(record -> {
                clienteRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return clienteRepository.findById(id).map(record -> {
           record.setNome(cliente.getNome()); 
           record.setDatanascimento(cliente.getDatanascimento());
           record.setSexo(cliente.getSexo());  
           record.setCpf(cliente.getCpf());
           record.setEndereco(cliente.getEndereco());

           return ResponseEntity.ok().body(clienteRepository.save(record));
        }).orElse(ResponseEntity.notFound().build());
    }
}
