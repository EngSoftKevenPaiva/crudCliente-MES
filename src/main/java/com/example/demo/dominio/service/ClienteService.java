// package com.example.demo.dominio.service;

// import java.util.List;
// import java.util.Optional;

// import com.example.demo.dominio.dto.ClienteDto;
// import com.example.demo.dominio.entity.Cliente;
// import com.example.demo.dominio.repository.ClienteRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.DeleteMapping;

// import lombok.AllArgsConstructor;

// @Service
// @AllArgsConstructor
// public class ClienteService {

//     @Autowired
//     ClienteDto clienteDto;

//     ClienteRepository clienteRepository;

//     public List<Cliente> listAll(){
//         return clienteRepository.findAll();
//     }

//     public Cliente save(Cliente cliente) {
//         return clienteRepository.save(cliente);
//     }

//     public Optional<Cliente> update(Long id, Cliente cliente) {
//         return clienteRepository.findById(id).map(record -> {
//             record.setName(cliente.getName());
//             record.setCpf(cliente.getCpf());
//             record.setSexo(cliente.getSexo());
//             record.setDataNascimento(cliente.getDataNascimento());

//             return clienteRepository.save(record);
//         });
//     }

//     public Optional<?> delete(Long id) {
//         return clienteRepository.findById(id).map(record -> {
//             clienteRepository.deleteById(id);
//         });
//     }
// }
