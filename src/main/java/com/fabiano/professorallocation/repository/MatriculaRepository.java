package com.fabiano.professorallocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fabiano.professorallocation.entity.Matriculado;

@Repository
public interface MatriculaRepository extends JpaRepository<Matriculado, Long> {
	List<Matriculado> findByAlunoId(Long aluno_id);

	List<Matriculado> findByCourseId(Long course_id);
}
