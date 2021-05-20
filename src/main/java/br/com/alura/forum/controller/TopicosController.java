package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository repo;
	
	@GetMapping
	public List<TopicoDto> getTopicos(String nomeCurso){
		List<Topico> lista = (nomeCurso == null) ?  repo.findAll() :
		 repo.findByCursoNome(nomeCurso); //
		return TopicoDto.converter(lista);
	}
	
	
	
	
	
	
}
