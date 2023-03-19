package com.fabiano.professorallocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fabiano.professorallocation.entity.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {

}
