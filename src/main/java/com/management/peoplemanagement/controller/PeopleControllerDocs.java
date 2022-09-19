package com.management.peoplemanagement.controller;

import com.management.peoplemanagement.dto.PeopleDTO;
import com.management.peoplemanagement.dto.PeopleResponseDTO;
import com.management.peoplemanagement.model.People;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@Api("Cadastro de Pessoas")
public interface PeopleControllerDocs {

    @ApiOperation(value = "Criação da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Pessoa criada com sucesso"),
            @ApiResponse(code = 400, message = "Campos faltando, valores informados divergentes ou a pessoa já está cadastrada")
    })
    PeopleResponseDTO create(PeopleDTO peopleToCreateDTO);

    @ApiOperation(value = "Atualizar o pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa atualizada com sucesso"),
            @ApiResponse(code = 400, message = "Campos faltando, valores informados divergentes ou o pessoa não está cadastrado"),
            @ApiResponse(code = 404, message = "Pessoa não encontrado com esse ID!")
    })
    PeopleResponseDTO update(Long id, PeopleDTO peopleToUpdateDTO);

    @ApiOperation(value = "Busca de Pessoa pelo Nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa encontrado com sucesso"),
            @ApiResponse(code = 404, message = "Pessoa não encontrado")
    })
    People findByName(String nome);

    @ApiOperation(value = "Lista todas as pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todas as pessoas")
    })
    List<PeopleDTO> findAll();

    @ApiOperation(value = "Exclusão de Pessoa pelo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Pessoa excluida com sucesso"),
            @ApiResponse(code = 404, message = "Pessoa não encontrada com esse ID!")
    })
    public void delete(Long id);
}
