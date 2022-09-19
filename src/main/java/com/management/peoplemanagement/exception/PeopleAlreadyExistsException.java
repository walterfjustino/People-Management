package com.management.peoplemanagement.exception;

import javax.persistence.EntityExistsException;

public class PeopleAlreadyExistsException extends EntityExistsException {
    public PeopleAlreadyExistsException(String nome, String sobrenome) {
        super(String.format("Usuário com esse nome: %s já existe!", nome + " " + sobrenome));
    }
}
