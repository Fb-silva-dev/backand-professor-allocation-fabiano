package com.fabiano.professorallocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.professorallocation.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
