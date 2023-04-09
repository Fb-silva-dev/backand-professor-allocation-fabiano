package com.fabiano.professorallocation.service;

import org.springframework.stereotype.Service;

import com.fabiano.professorallocation.repository.AllocationRepository;

@Service
public class AllocationService {
	 
	private final AllocationRepository repository;
	
	public AllocationService(AllocationRepository repository) {
		
		super ();
		this.repository = repository;
		
	}
	
	
}
