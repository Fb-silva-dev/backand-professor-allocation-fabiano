package com.fabiano.professorallocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.professorallocation.entity.Matriculado;

@Repository
public interface MatriculaRepository extends JpaRepository<Matriculado, Long> {

}
