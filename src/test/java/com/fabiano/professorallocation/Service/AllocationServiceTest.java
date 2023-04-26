package com.fabiano.professorallocation.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.fabiano.professorallocation.entity.Allocation;
import com.fabiano.professorallocation.service.AllocationService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationServiceTest {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	AllocationService allocationService;

	@Test
	// Todas as Alocações
	public void findAll() {
		// Act
		List<Allocation> allocations = allocationService.findAll();

		// Print
		allocations.forEach(System.out::println);
	}

	@Test
	public void findByProfessor() {
		// Arrange
		Long id = 1L;

		// Act
		List<Allocation> allocations = allocationService.findByProfessor(id);

		// Print
		allocations.forEach(System.out::println);
	}

	@Test
	public void findByCourse() {

		Long id = 1L;
		List<Allocation> allocations = allocationService.findByCourse(id);
		allocations.forEach(System.out::println);
	}

	@Test
	public void findById() {
		Long id = 1L;
		Allocation allocation = allocationService.findById(id);
		System.out.println(allocation);
	}

	@Test
	public void save() throws ParseException {
		Allocation allocation = new Allocation();
		allocation.setId(null);
		allocation.setDay(DayOfWeek.WEDNESDAY);
		allocation.setInicioHora(sdf.parse("19:00-0300"));
		allocation.setFimHora(sdf.parse("20:00-0300"));
		allocation.setProfessorId(1L);
		allocation.setCourseId(1L);

		allocation = allocationService.save(allocation);

		System.out.println(allocation); 
	}

	@Test
	public void update() throws ParseException {
		// Arrange
		Allocation allocation = new Allocation();
		allocation.setId(1L);
		allocation.setDay(DayOfWeek.MONDAY);
		allocation.setInicioHora(sdf.parse("19:00-0300"));
		allocation.setFimHora(sdf.parse("20:00-0300"));
		allocation.setProfessorId(1L);
		allocation.setCourseId(1L);

		// Act
		allocation = allocationService.update(allocation);

		// Print
		System.out.println(allocation);
	}

	@Test
	public void deleteById() {
		Long id = 1L;
		allocationService.deleteById(id);
	}

	@Test
	public void deleteAll() {
		allocationService.deleteAll();
	}

}
