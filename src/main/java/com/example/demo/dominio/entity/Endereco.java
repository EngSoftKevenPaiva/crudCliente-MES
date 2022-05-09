package com.example.demo.dominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enderecos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    @NotBlank(message = "cep é obrigatório")
    @Length(max = 8, message = "cep deve ter 8 dígitos")
    String cep;

    @Column
    @NotBlank(message = "rua é obrigatório")
    @Length(max = 100, message = "rua deve ter até 100 dígitos")
    String rua;

    @Column
    @NotBlank(message = "bairro é obrigatório")
    @Length(max = 100, message = "bairro deve ter até 100 dígitos")
    String bairro;

    @Column
    @NotNull(message = "número é obrigatório")
    int numero;

    @Column
    @NotBlank(message = "cidade é obrigatório")
    @Length(max = 100, message = "cidade deve ter até 100 dígitos")
    String cidade;

    @Column
    @NotBlank(message = "uf é obrigatório")
    @Length(max = 2, message = "uf deve ter 2 dígitos")
    String uf;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;
}
