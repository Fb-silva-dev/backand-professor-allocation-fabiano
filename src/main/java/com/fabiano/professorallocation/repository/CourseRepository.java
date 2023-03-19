package com.fabiano.professorallocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiano.professorallocation.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
