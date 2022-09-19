package com.management.peoplemanagement.service;

import com.management.peoplemanagement.dto.PeopleDTO;
import com.management.peoplemanagement.dto.PeopleResponseDTO;
import com.management.peoplemanagement.model.People;

import java.util.List;

public interface PeopleService {

    PeopleResponseDTO create(PeopleDTO peopleToCreateDTO);

    PeopleResponseDTO update(Long id, PeopleDTO peopleToUpdateDTO);

    People findByName(String nome);

    List<PeopleDTO> findAll();

    public void delete(Long id);
}
