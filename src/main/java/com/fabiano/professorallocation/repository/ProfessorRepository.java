package com.fabiano.professorallocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.professorallocation.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
