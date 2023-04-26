package com.fabiano.professorallocation.Service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.fabiano.professorallocation.entity.Course;
import com.fabiano.professorallocation.service.CourseService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class CourseServiceTest {
	@Autowired
	CourseService courseService;

	@Test
	public void findAll() {

		List<Course> courses = courseService.findAll(null);

		courses.forEach(System.out::println);
	}

	@Test
	public void findAllByName() {

		String name = "course";

		List<Course> courses = courseService.findAll(name);

		courses.forEach(System.out::println);
	}

	@Test
	public void findById() {

		Long id = 1L;

		Course course = courseService.findById(id);

		System.out.println(course);
	}

	@Test
	public void save() {

		Course course = new Course();
		course.setId(null);
		course.setName("Test de Software");
		course = courseService.save(course);
		System.out.println(course);
	}
}
