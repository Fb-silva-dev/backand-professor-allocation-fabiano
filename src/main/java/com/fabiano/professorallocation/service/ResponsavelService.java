package com.fabiano.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fabiano.professorallocation.entity.Aluno;
import com.fabiano.professorallocation.entity.Responsavel;
import com.fabiano.professorallocation.repository.AlunoRepository;
import com.fabiano.professorallocation.repository.ResponsavelRepository;

@Service
public class ResponsavelService {

	private final ResponsavelRepository responsavelRepository;
	private final AlunoRepository alunoRepository;

	public ResponsavelService(ResponsavelRepository responsavelRepository, AlunoRepository alunoRepository) {
		super();
		this.responsavelRepository = responsavelRepository;
		this.alunoRepository = alunoRepository;
	}

	public List<Responsavel> findAll(String name) {
		if (name == null) {
			return responsavelRepository.findAll();
		} else {
			return responsavelRepository.findByNameContainingIgnoreCase(name);
		}
	}

	public Responsavel findById(Long id) {
		return responsavelRepository.findById(id).orElse(null);
	}

	public Responsavel save(Responsavel responsavel) {
		responsavel.setId(null);
		return saveInternal(responsavel);
	}

	public Responsavel update(Responsavel responsavel) {
		Long id = responsavel.getId();
		if (id != null && responsavelRepository.existsById(id)) {
			return saveInternal(responsavel);
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		if (id != null && responsavelRepository.existsById(id)) {
			responsavelRepository.deleteById(id);
		}
	}

	public void deleteAll() {
		responsavelRepository.deleteAllInBatch();
	}

	private Responsavel saveInternal(Responsavel responsavel) {
		responsavel = responsavelRepository.save(responsavel);

		//findByResponsavel ( Eu substitui por long pois pareceu funcionar assim presciso de uma dica)
		List<Aluno> alunos = alunoRepository.findByResponsavelId(responsavel.getId());
		responsavel.setAlunos(alunos);
		return responsavel;
	}

}
