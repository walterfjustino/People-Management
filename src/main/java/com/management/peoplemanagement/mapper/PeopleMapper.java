package com.management.peoplemanagement.mapper;

import com.management.peoplemanagement.dto.PeopleDTO;
import com.management.peoplemanagement.dto.PeopleResponseDTO;
import com.management.peoplemanagement.model.People;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PeopleMapper {
    PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);

    People toModel(PeopleDTO peopleDTO);

    PeopleDTO toDTO(People people);

    PeopleResponseDTO toResponseModel(People  people);

    PeopleResponseDTO toResponseDTO(PeopleDTO  peopleDTO);
    
}
