package com.fabiano.professorallocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import com.fabiano.professorallocation.entity.Matricula;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class MatriculaRepositoryTest {

	@Autowired
	MatriculaRepository repository;
	
	@Test
	public void findAll() {
		List<Matricula> items = repository.findAll();
		
		System.out.println("Qtd elementos retornados: " + items.size());
		
		for(Matricula item : items) {
			System.out.println(item);
		}
	}
	
	@Test
	public void create() {
		Matricula matricula = new Matricula();
		//matricula.setAlunoId(1L);
		matricula.setCourseId(1L);
		
		matricula = repository.save(matricula);
		System.out.println(matricula);
	}
}
