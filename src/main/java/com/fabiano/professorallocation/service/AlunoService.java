package com.fabiano.professorallocation.service;

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
}
