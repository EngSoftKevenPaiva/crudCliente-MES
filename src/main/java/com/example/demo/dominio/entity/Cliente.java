package com.example.demo.dominio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    @CPF(message = "cpf inválido")
    String cpf;

    @Column
    @NotBlank(message = "nome é obrigatório")
    String nome;

    @Column
    @NotBlank(message = "sexo é obrigatório")
    String sexo;

    @Temporal(value=TemporalType.DATE)
    @Column
    Date datanascimento;
}
