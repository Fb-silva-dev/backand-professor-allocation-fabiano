package com.fabiano.professorallocation.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fabiano.professorallocation.entity.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
	List<Responsavel> findByNameContainingIgnoreCase(String name);

}
