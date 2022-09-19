package com.management.peoplemanagement.exception;

import javax.persistence.EntityExistsException;

public class PeopleWithIdNotFoundException extends EntityExistsException {

    public PeopleWithIdNotFoundException(Long id) {
        super(String.format("Usuário com esse id: %s não encontrado!", id));
    }
}
