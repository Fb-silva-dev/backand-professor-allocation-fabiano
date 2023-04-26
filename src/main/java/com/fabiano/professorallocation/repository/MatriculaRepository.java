package com.fabiano.professorallocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.professorallocation.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
	
	List<Matricula> findByAlunoId(Long aluno_id);

	List<Matricula> findByCourseId(Long course_id);
}
