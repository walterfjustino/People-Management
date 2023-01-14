package com.management.peoplemanagement.repository;

import com.management.peoplemanagement.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    Optional<People> findByNomeAndSobrenome(String nome, String Sobrenome);
    Optional<People> findByNomeOrderByNome(String nome);
}

