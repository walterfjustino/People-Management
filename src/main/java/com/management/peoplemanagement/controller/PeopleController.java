package com.management.peoplemanagement.controller;

import com.management.peoplemanagement.dto.PeopleDTO;
import com.management.peoplemanagement.dto.PeopleResponseDTO;
import com.management.peoplemanagement.model.People;
import com.management.peoplemanagement.service.PeopleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleController implements PeopleControllerDocs{

    @Autowired
    private PeopleServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public PeopleResponseDTO create(@RequestBody @Valid PeopleDTO peopleToCreateDTO) {
        return service.create(peopleToCreateDTO);    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public PeopleResponseDTO update(@PathVariable Long id, @RequestBody @Valid PeopleDTO peopleToUpdateDTO) {
        return service.update(id, peopleToUpdateDTO);
    }

    @GetMapping("/{nome}")
    @Override
    public People findByName(@PathVariable String nome) {
        return service.findByName(nome);
    }

    @GetMapping
    @Override
    public List<PeopleDTO> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
