package com.fabiano.professorallocation.service;

import org.springframework.stereotype.Service;
import com.fabiano.professorallocation.repository.AllocationRepository;

@Service
public class AllocationService {
	 
	private final AllocationRepository allocationRepository;
	private final ProfessorService professorService;
	private final CourseService courseService;
	
	public AllocationService(AllocationRepository allocationRepository, ProfessorService professorService,
			CourseService courseService) {
		super();
		this.allocationRepository = allocationRepository;
		this.professorService = professorService;
		this.courseService = courseService;
	}
}
