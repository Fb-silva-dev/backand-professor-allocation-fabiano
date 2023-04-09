package com.fabiano.professorallocation.service;

import org.springframework.stereotype.Service;
import com.fabiano.professorallocation.repository.ResponsavelRepository;

@Service
public class ResponsavelService {

	private final ResponsavelRepository repository;

	public ResponsavelService(ResponsavelRepository repository) {
		super();
		this.repository = repository;
	}
	
}
