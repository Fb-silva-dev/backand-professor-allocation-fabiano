package com.fabiano.professorallocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.fabiano.professorallocation.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {

	@Autowired
	DepartmentRepository repository;

	@Test
	public void findAll() { // Buscar todos os elementos da tabela
		List<Department> items = repository.findAll();

		System.out.println("Qtd elementos retornados: " + items.size());

		for (Department item : items) {
			System.out.println(item);
		}
	}

	@Test
	public void create() {
		Department department = new Department();
		//department.setName("Departamento de Informatica");
		//department.setName("Departamento de Biologia");
		department.setName("Departamento de Ciencias");
		//department.setName("Departamento de Engenharia");

		// System.out.println("Id atual:" + department.getId());
		department = repository.save(department);
		System.out.println(department);
		// System.out.println("Id depois de Salvar:" + department.getId());
	}

	@Test
	public void update() {

		Department department = new Department();// Criar um novo departamento
		department.setId(3L);// buscar o id para alterar o nome
		// Novo nome a ser colocado
		department.setName("Departamento de Saude");
		department = repository.save(department);// Salvar o novo nome atribuido ao id selecionado
		System.out.println(department);
	}

	@Test
	public void delete() {
		repository.deleteById(3L);// Deletar um Departamento por ID
	}

	@Test
	public void deleteAllItems() {// Deletar todos os departamentos (Usar com cuidade)
		repository.deleteAllInBatch();
	}

	@Test
	public void findSpecifcDepartment() {// Buscar um Departamento pelo Id e caso não encontre retornar nulo
		Department dept = repository.findById(4L).orElse(null);
		System.out.println(dept);

	}
}
