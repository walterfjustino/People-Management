package com.management.peoplemanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.management.peoplemanagement.enums.TipoIdentificador;
//import com.management.peoplemanagement.util.CnpjGroup;
//import com.management.peoplemanagement.util.CpfGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleDTO {

    private Long id;

    @NotBlank(message = "Informar o nome da pessoa")
    @Size(max = 200, message = "maximo de 200 caracteres permitido para o nome")
    private String nome;

    @NotBlank(message = "Informar o sobrenome da pessoa")
    @Size(max = 200, message = "maximo de 200 caracteres permitido para o sobrenome")
    private String sobrenome;

    @NotBlank(message = "informar o tipo identificador")
    @Enumerated(EnumType.STRING)
    private TipoIdentificador tipoIdentificador;

    @NotBlank(message = " informar CPF/CNPJ")

    @NotBlank(message = " informar CPF ou CNPJ")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/aaaa")
    @Pattern(regexp =  "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((?:19|20)[0-9][0-9])", message = "preencher data no formato: dd/MM/aaaa")
    private String cpfOuCnpj;

    @NotBlank(message = "Informar a data de nascimento da pessoa")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/aaaa")
    @Pattern(regexp =  "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((?:19|20)[0-9][0-9])", message = "preencher data no formato: dd/MM/aaaa")
    @Size(max = 10, min = 10, message = "preencher data no formato: dd/MM/aaaa")
    private String dataNascimento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(00)000000000")
    @NotBlank(message = "Informar um telefone de contato")
    @Size(max = 13, min = 13, message = "número de telefone necessário preencher 11 caracteres, no formato: (00)000000000 ")
    private String telefone;
}

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "CPF: 000.000.000-00 / CNPJ: 00.000.000/0001-00")
//    @Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})")