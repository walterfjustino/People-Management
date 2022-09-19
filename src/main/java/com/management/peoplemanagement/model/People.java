package com.management.peoplemanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.management.peoplemanagement.enums.TipoIdentificador;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoIdentificador tipoIdentificador;

    @Column(nullable = false, name = "CPF_CNPJ")
    private String cpfOuCnpj;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/aaaa")
    @Column
    private String dataNascimento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(00)000000000")
    @Column
    private String telefone;
}

