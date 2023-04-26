package com.fabiano.professorallocation.Service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.fabiano.professorallocation.entity.Responsavel;
import com.fabiano.professorallocation.service.ResponsavelService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ResponsavelServiceTest {

	@Autowired
	ResponsavelService responsavelService;

	@Test
	public void findAll() {

		List<Responsavel> responsaves = responsavelService.findAll(null);

		responsaves.forEach(System.out::println);
	}

	@Test
	public void findAllByName() {

		String name = "responsavel";

		List<Responsavel> responsavel = responsavelService.findAll(name);

		responsavel.forEach(System.out::println);
	}

	@Test
	public void findById() {

		Long id = 1L;

		Responsavel responsavel = responsavelService.findById(id);

		System.out.println(responsavel);
	}

	@Test
	public void save() {

		Responsavel responsavel = new Responsavel();
		responsavel.setId(null);
		responsavel.setName("Marcos Agusto");
		responsavel.setTelefone("81997835908");
		responsavel.setAlunoId(1l);
		responsavel = responsavelService.save(responsavel);
		System.out.println(responsavel);
	}

	@Test
	public void update() {

		Responsavel responsavel = new Responsavel();
		responsavel.setId(1L);
		responsavel.setName("josé carlos");

		responsavel = responsavelService.update(responsavel);

		System.out.println(responsavel);
	}
	
	  @Test
	    public void deleteById() {
	       
	        Long id = 1L;
       
	        responsavelService.deleteById(id);
	    }

	    @Test
	    public void deleteAll() {
	        
	        responsavelService.deleteAll();
	    }
}
