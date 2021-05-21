package br.com.alura.forum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository repo;
	
	@Autowired
	private CursoRepository cursoRepository;
	//@Cacheable(key = "first")
	@GetMapping
	public List<TopicoDto> Find(String nomeCurso){
		System.out.println("chegou uma nova requisicao");
		List<Topico> lista = (nomeCurso == null) ?  repo.findAll() :
		 repo.findByCursoNome(nomeCurso); //
		return TopicoDto.converter(lista);
	}
	
	@PostMapping
	public ResponseEntity<TopicoDto> Insert(@RequestBody @Valid TopicoForm tpForm,UriComponentsBuilder uriBuilder) {
		System.out.println("chegou uma nova requisicao");
		Topico topico = tpForm.converter(cursoRepository);
		repo.save(topico);
		return ResponseEntity.created(uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri()).body(new TopicoDto(topico));
	}
	
	
	
	
	
	
}
