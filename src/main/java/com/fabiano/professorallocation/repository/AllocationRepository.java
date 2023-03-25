package com.fabiano.professorallocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fabiano.professorallocation.entity.Allocation;
import com.fabiano.professorallocation.entity.Course;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {
	List<Allocation> findByProfessorId(Long professor_id);

	List<Course> findByCourseId(Long course_id);

}
