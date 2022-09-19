package com.management.peoplemanagement.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoIdentificador {

    CPF( "Pessoa Física", "000.000.000-00"),
    CNPJ("Pessoa Jurídica","00.000.000/0000-00");

    private final String descricao;
    private final String formato;

}