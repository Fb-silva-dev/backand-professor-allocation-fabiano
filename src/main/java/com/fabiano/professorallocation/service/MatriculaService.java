package com.fabiano.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.fabiano.professorallocation.entity.Aluno;
import com.fabiano.professorallocation.entity.Course;
import com.fabiano.professorallocation.entity.Matricula;
import com.fabiano.professorallocation.repository.MatriculaRepository;

@Service
public class MatriculaService {

	private final MatriculaRepository matriculaRepository;
	private final CourseService courseService;
	private final AlunoService alunoService;

	public MatriculaService(MatriculaRepository matriculaRepository, AlunoService alunoService,
			CourseService courseService) {
		super();
		this.matriculaRepository = matriculaRepository;
		this.alunoService = alunoService;
		this.courseService = courseService;
	}
	
	public List<Matricula> findAll() {
		return matriculaRepository.findAll();
	}

	public Matricula findById(Long id) {
		return matriculaRepository.findById(id).orElse(null);
	}

	public List<Matricula> findByCourse(Long courseId) {
		return matriculaRepository.findByCourseId(courseId);
	}

	public List<Matricula> findByAluno(Long alunoId) {
		return matriculaRepository.findByAlunoId(alunoId);
	}

	public Matricula save(Matricula matricula) {
		matricula.setId(null);
		return saveInternal(matricula);
	}

	public Matricula update(Matricula matricula) {
		Long id = matricula.getId();
		if (id != null && matriculaRepository.existsById(id)) {
			return saveInternal(matricula);
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		if (id != null && matriculaRepository.existsById(id)) {
			matriculaRepository.deleteById(id);
		}
	}

	public void deleteAll() {
		matriculaRepository.deleteAllInBatch();
	}

	private Matricula saveInternal(Matricula matricula) {

		matricula = matriculaRepository.save(matricula);

		Aluno aluno = alunoService.findById(matricula.getAlunoId());
		matricula.setAluno(aluno);

		Course course = courseService.findById(matricula.getCourseId());
		matricula.setCourse(course);

		return matricula;
	}

	boolean hasCollision(Matricula newMatricula) {
		boolean hasCollision = false;

		List<Matricula> currentMatriculas = matriculaRepository.findByAlunoId(newMatricula.getAlunoId());

		for (Matricula currentMatricula : currentMatriculas) {
			hasCollision = hasCollision(currentMatricula, newMatricula);
			if (hasCollision) {
				break;
			}
		}

		return hasCollision;
	}

	private boolean hasCollision(Matricula currentMatricula, Matricula newMatricula) {
		// TODO Auto-generated method stub
		return false;
	}

}
