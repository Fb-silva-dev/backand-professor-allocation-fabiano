package com.fabiano.professorallocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import com.fabiano.professorallocation.entity.Aluno;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AlunoRepositoryTest {

	@Autowired
	AlunoRepository repository;

	@Test
	public void findAll() {
		List<Aluno> items = repository.findAll();

		System.out.println("Qtd elementos retornados: " + items.size());

		for (Aluno item : items) {
			System.out.println(item);
		}
	}

	@Test
	public void create() {
		Aluno aluno = new Aluno();
		aluno.setName("Manoel");
		aluno.setBairro("Jardim Brasil");
		aluno.setRua("Mataripe");
		aluno.setNumero(33L);
		aluno.setCpf("00987654986");
		aluno.setCep("53300300");
		aluno.setIdade(35L);
		aluno.setMatricula(null);
		
	
		// System.out.println("Id atual:" + department.getId());
		aluno = repository.save(aluno);
		System.out.println(aluno);
		// System.out.println("Id depois de Salvar:" + department.getId());
	}
}
