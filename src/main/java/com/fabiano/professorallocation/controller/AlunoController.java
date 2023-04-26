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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fabiano.professorallocation.entity.Aluno;
import com.fabiano.professorallocation.service.AlunoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/professors")
public class AlunoController {

	private final AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		super();
		this.alunoService = alunoService;
	}

	@ApiOperation(value = "Find all alunos")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK") })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Aluno>> findAll(@RequestParam(name = "name", required = false) String name) {
		List<Aluno> alunos = alunoService.findAll(name);
		return new ResponseEntity<>(alunos, HttpStatus.OK);
	}

	@ApiOperation(value = "Find a aluno")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(path = "/{aluno_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Aluno> findById(@PathVariable(name = "professor_id") Long id) {
		Aluno aluno = alunoService.findById(id);
		if (aluno == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(aluno, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Find professors by department")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request") })
	@GetMapping(path = "/department/{department_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Aluno>> findByMatricula(@PathVariable(name = "Matricula_id") Long id) {
		List<Aluno> alunos = alunoService.findByMatricula(id);
		return new ResponseEntity<>(alunos, HttpStatus.OK);
	}

	@ApiOperation(value = "Save a professor")
	@ApiResponses({ @ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad Request") })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
		try {
			aluno = alunoService.save(aluno);
			return new ResponseEntity<>(aluno, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Update a professor")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PutMapping(path = "/{professor_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Aluno> update(@PathVariable(name =  "aluno_id") Long id,
			@RequestBody Aluno aluno) {
		aluno.setId(id);
		try {
			aluno = alunoService.update(aluno);
			if (aluno == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(aluno, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Delete a aluno")
	@ApiResponses({ @ApiResponse(code = 204, message = "No Content") })
	@DeleteMapping(path = "/{aluno_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable(name = "aluno_id") Long id) {
		alunoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Delete all alunos")
	@ApiResponses({ @ApiResponse(code = 204, message = "No Content") })
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAll() {
		alunoService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

