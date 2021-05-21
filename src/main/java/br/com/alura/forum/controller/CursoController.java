package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.CursosDTO;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.repository.CursoRepository;

@RestController
@RequestMapping("cursos")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepo;
	@GetMapping
	public ResponseEntity<List<CursosDTO>> getCursos(){
		List<Curso> curso = cursoRepo.findAll();
		return ResponseEntity.ok().body(CursosDTO.conversor(curso));
	}

}
