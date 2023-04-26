package com.fabiano.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fabiano.professorallocation.entity.Aluno;
import com.fabiano.professorallocation.repository.AlunoRepository;

@Service
public class AlunoService {

private final AlunoRepository repository;

public AlunoService(AlunoRepository repository) {
	super();
	this.repository = repository;
}

public Aluno create(Aluno aluno) {
	// uma criação so pode ser feita quando não exisxtir um id
	aluno.setId(null);
	return saveInternal(aluno);
}

public Aluno update(Aluno aluno) {
	Long id = aluno.getId();
	// atualizar um aquivo que exixte.
	if (id == null || !repository.existsById(id)) {
		return null;
	} else {
		return saveInternal(aluno);
	}
}

private Aluno saveInternal(Aluno aluno) {
	Aluno insertedAluno = repository.save(aluno);
	return insertedAluno;
}

public void deleteById(Long id) {

	if (repository.existsById(id)) {

		repository.deleteById(id);
	}
}

public Aluno findById(Long id) {
	return repository.findById(id).orElse(null);

}

public List<Aluno> findAll() {
	return repository.findAll();
}

public List<Aluno> findByMatricula(Long id) {
	
	return null;
}

public Aluno save(Aluno aluno) {
	
	return null;
}

public void deleteAll() {
	
}

public List<Aluno> findAll(String name) {
	
	return null;
}

}
