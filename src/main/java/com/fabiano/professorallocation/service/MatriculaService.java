package com.fabiano.professorallocation.service;


import org.springframework.stereotype.Service;

import com.fabiano.professorallocation.repository.MatriculaRepository;

@Service
public class MatriculaService {
	

	private final MatriculaRepository repository;

	public MatriculaService(MatriculaRepository repository) {
		super();
		this.repository = repository;
	}

}
