package com.fabiano.professorallocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import com.fabiano.professorallocation.entity.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {

	@Autowired
	CourseRepository repository;
	
	@Test
	public void findAll() { // Buscar todos os elementos da tabela
		List<Course> items = repository.findAll();

		System.out.println("Qtd elementos retornados: " + items.size());
 
		for (Course item : items) {
			System.out.println(item);
		}
	} 
	
	@Test
	public void create() {
		Course course = new Course();
		//course.setId(null);
		course.setName("Logica de Programação");
		course.setValor(180.00);
		course.setMatricula(null);

		course = repository.save(course);
		System.out.println(course);
	}	
}
