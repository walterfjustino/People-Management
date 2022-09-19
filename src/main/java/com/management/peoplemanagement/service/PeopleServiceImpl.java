package com.management.peoplemanagement.service;

import com.management.peoplemanagement.dto.PeopleDTO;
import com.management.peoplemanagement.dto.PeopleResponseDTO;
import com.management.peoplemanagement.enums.TipoIdentificador;
import com.management.peoplemanagement.exception.PeopleAlreadyExistsException;
import com.management.peoplemanagement.exception.PeopleNotFoundException;
import com.management.peoplemanagement.exception.PeopleWithIdNotFoundException;
import com.management.peoplemanagement.mapper.PeopleMapper;
import com.management.peoplemanagement.model.People;
import com.management.peoplemanagement.repository.PeopleRepository;
//import com.management.peoplemanagement.util.CnpjGroup;
//import com.management.peoplemanagement.util.CpfGroup;
import lombok.AllArgsConstructor;
import org.hibernate.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleServiceImpl implements PeopleService{

    public static final PeopleMapper mapper = PeopleMapper.INSTANCE;

    @Autowired
    private PeopleRepository repository;

    @Override
    public PeopleResponseDTO create(PeopleDTO peopleToCreateDTO) {
        verifyIfPeopleExists(peopleToCreateDTO.getNome(), peopleToCreateDTO.getSobrenome());
        verifyTipoIdentificador(peopleToCreateDTO.getTipoIdentificador().toString(), peopleToCreateDTO.getCpfOuCnpj());
        var peopleToCreate = mapper.toModel(peopleToCreateDTO);
        var createdPeople = repository.save(peopleToCreate);
        return mapper.toResponseModel(createdPeople);
    }

    @Override
    public PeopleResponseDTO update(Long id, PeopleDTO peopleToUpdateDTO) {
        var foundPeople = verifyIfPeopleExistsAndGet(id);
        verifyTipoIdentificador(peopleToUpdateDTO.getTipoIdentificador().toString(), peopleToUpdateDTO.getCpfOuCnpj());
        peopleToUpdateDTO.setId(foundPeople.getId());
        var peopleUpdate = mapper.toModel(peopleToUpdateDTO);
        var updatedPeople = repository.save(peopleUpdate);
        return mapper.toResponseModel(updatedPeople) ;
    }

    @Override
    public People findByName(String nome) {
        return repository.findByNomeOrderByNome(nome)
                .orElseThrow(()-> new PeopleNotFoundException(nome));
    }

    @Override
    public List<PeopleDTO> findAll() {
        return repository.findAll()
                .stream().map(mapper::toDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        verifyIfPeopleExistsAndGet(id);
        repository.deleteById(id);
    }

    private void verifyIfPeopleExists(String nome, String sobrenome) {
        repository.findByNomeAndSobrenome(nome, sobrenome)
                .ifPresent(people -> {throw new PeopleAlreadyExistsException(nome, sobrenome);});
    }
    private People verifyIfPeopleExistsAndGet(Long id) {
       return  repository.findById(id)
                .orElseThrow(() -> new PeopleWithIdNotFoundException(id));
    }

    private void verifyTipoIdentificador(String tipoIdentificador, String cpfOuCnpj){
        try{
            if (tipoIdentificador != null) {
                if ("CPF".equalsIgnoreCase(tipoIdentificador) && cpfOuCnpj.length() == 14)  {
                } else if ("CNPJ".equalsIgnoreCase(tipoIdentificador) && cpfOuCnpj.length() == 18) {
                }else {
                    throw new TypeMismatchException("Tipo identificador invalido:" + "tipo identificador: " + tipoIdentificador + " CPF ou CNPJ: " + cpfOuCnpj);
                }
            }
        } catch (Exception e) {
            throw new TypeMismatchException("Tipo identificador invalido:" + e.getMessage());
        }
    }
}
