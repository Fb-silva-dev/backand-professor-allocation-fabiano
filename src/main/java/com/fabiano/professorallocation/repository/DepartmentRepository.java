package com.fabiano.professorallocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.professorallocation.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
