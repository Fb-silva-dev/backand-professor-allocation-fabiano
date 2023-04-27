package com.fabiano.professorallocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fabiano.professorallocation.entity.Matricula;
import com.fabiano.professorallocation.service.MatriculaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/matriculas")
public class MatriculaController {

	private final MatriculaService matriculaService;

	public MatriculaController(MatriculaService matriculaService) {
		super();
		this.matriculaService = matriculaService;
	}

	@ApiOperation(value = "Find all matriculas")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK") })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Matricula>> findAll() {
		List<Matricula> matriculas = matriculaService.findAll();
		return new ResponseEntity<>(matriculas, HttpStatus.OK);
	}

	@ApiOperation(value = "Find an matricula by id")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(path = "/{matricula_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Matricula> findById(@PathVariable(name = "matricula_id") Long id) {
		Matricula matricula = matriculaService.findById(id);
		if (matricula == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(matricula, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Find matricula by aluno")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request") })
	@GetMapping(path = "/aluno/{aluno_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Matricula>> findByAluno(@PathVariable(name = "aluno_id") Long id) {
		List<Matricula> matriculas = matriculaService.findByAluno(id);
		return new ResponseEntity<>(matriculas, HttpStatus.OK);
	}

	@ApiOperation(value = "Find allocations by course")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request") })
	@GetMapping(path = "/course/{course_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Matricula>> findByCourse(@PathVariable(name = "course_id") Long id) {
		List<Matricula> matriculas = matriculaService.findByCourse(id);
		return new ResponseEntity<>(matriculas, HttpStatus.OK);
	}

	@ApiOperation(value = "Save an matricula")
	@ApiResponses({ @ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad Request") })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Matricula> save(@RequestBody Matricula matricula) {
		try {
			matricula = matriculaService.save(matricula);
			return new ResponseEntity<>(matricula, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Update an matricula")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PutMapping(path = "/{matricula_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Matricula> update(@PathVariable(name = "matricula_id") Long id,
			@RequestBody Matricula matricula) {
		matricula.setId(id);
		try {
			matricula = matriculaService.update(matricula);
			if (matricula == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(matricula, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Delete an matricula")
	@ApiResponses({ @ApiResponse(code = 204, message = "No Content") })
	@DeleteMapping(path = "/{matricula_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable(name = "matricula_id") Long id) {
		matriculaService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Delete all matriculas")
	@ApiResponses({ @ApiResponse(code = 204, message = "No Content") })
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAll() {
		matriculaService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
