package com.fabiano.professorallocation.service;

import org.springframework.stereotype.Service;

import com.fabiano.professorallocation.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private final DepartmentRepository repository;

	public DepartmentService(DepartmentRepository repository) {
		super();
		this.repository = repository;
	}
}
