package com.management.peoplemanagement.repository;

import com.management.peoplemanagement.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    Optional<People> findByNomeAndSobrenome(String nome, String Sobrenome);

    @Query(value = "SELECT * FROM usuario WHERE nome LIKE ? ORDER BY nome, sobrenome", nativeQuery = true)
    Optional<People> findByNomeOrderByNome(String nome);
}

