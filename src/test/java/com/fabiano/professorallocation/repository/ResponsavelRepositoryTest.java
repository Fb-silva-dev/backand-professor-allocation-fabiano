package com.fabiano.professorallocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.fabiano.professorallocation.entity.Responsavel;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class ResponsavelRepositoryTest {

	@Autowired
	ResponsavelRepository repository;

	@Test
	public void findAll() {
		List<Responsavel> items = repository.findAll();

		System.out.println("Qtd elementos retornados: " + items.size());

		for (Responsavel item : items) {
			System.out.println(item);
		}
	}
	
	@Test
	public void create() {
		
		Responsavel responsavel = new Responsavel();
		responsavel.setCpf("98767776543");
		responsavel.setName("Igor Farias");
		responsavel.setTelefone("81996756543");
		responsavel.setAlunoId(1L);
		
		responsavel = repository.save(responsavel);
		System.out.println(responsavel);
	}
}
