package com.fabiano.professorallocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fabiano.professorallocation.entity.Course;
import com.fabiano.professorallocation.entity.Matricula;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
List<Matricula>findByMatricula(Long matriculaId);
}
