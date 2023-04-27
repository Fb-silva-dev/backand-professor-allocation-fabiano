package com.fabiano.professorallocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import com.fabiano.professorallocation.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class ProfessorRepositoryTest {

	@Autowired
	ProfessorRepository repository;

	@Test
	public void findAll() {
		List<Professor> items = repository.findAll();

		System.out.println("Qtd elementos retornados: " + items.size());

		for (Professor item : items) {
			System.out.println(item);
		}
	}
	
	@Test
	public void create() { 
		Professor professor = new Professor();
		professor.setName("Lucas Godoy");
		professor.setCpf("00897654321");
		professor.setDepartmentId(1L);
		
		// System.out.println("Id atual:" + department.getId());
		professor = repository.save(professor);
		System.out.println(professor);
		// System.out.println("Id depois de Salvar:" + department.getId());
	}
}
