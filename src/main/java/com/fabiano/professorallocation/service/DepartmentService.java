package com.fabiano.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fabiano.professorallocation.entity.Department;
import com.fabiano.professorallocation.entity.Professor;
import com.fabiano.professorallocation.repository.DepartmentRepository;
import com.fabiano.professorallocation.repository.ProfessorRepository;

@Service
public class DepartmentService {
	
	    private final DepartmentRepository departmentRepository;
	    private final ProfessorRepository professorRepository;

	    public DepartmentService(DepartmentRepository departmentRepository, ProfessorRepository professorRepository) {
	        super();
	        this.departmentRepository = departmentRepository;
	        this.professorRepository = professorRepository;
	    }

	    public List<Department> findAll(String name) {
	        if (name == null) {
	            return departmentRepository.findAll();
	        } else {
	            return departmentRepository.findByNameContainingIgnoreCase(name);
	        }
	    }

	    public Department findById(Long id) {
	        return departmentRepository.findById(id).orElse(null);
	    }

	    public Department save(Department department) {
	        department.setId(null);
	        return saveInternal(department);
	    }

	    public Department update(Department department) {
	        Long id = department.getId();
	        if (id != null && departmentRepository.existsById(id)) {
	            return saveInternal(department);
	        } else {
	            return null;
	        }
	    }

	    public void deleteById(Long id) {
	        if (id != null && departmentRepository.existsById(id)) {
	            departmentRepository.deleteById(id);
	        }
	    }

	    public void deleteAll() {
	        departmentRepository.deleteAllInBatch();
	    }

	    private Department saveInternal(Department department) {
	        department = departmentRepository.save(department);

	        List<Professor> professors = professorRepository.findByDepartment(department.getId());
	        department.setProfessors(professors);

	        return department;
	    }	
}
