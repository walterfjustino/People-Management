package com.management.peoplemanagement.exception;

import javax.persistence.EntityExistsException;

public class PeopleNotFoundException extends EntityExistsException {
    public PeopleNotFoundException(String nome) {
        super(String.format("Usuário com esse nome: %s não encontrado!", nome));
    }
}
