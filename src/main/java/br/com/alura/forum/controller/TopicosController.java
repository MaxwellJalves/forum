package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping
	public List<TopicoDto> Find(String nomeCurso){
		List<Topico> lista = (nomeCurso == null) ?  repo.findAll() :
		 repo.findByCursoNome(nomeCurso); //
		return TopicoDto.converter(lista);
	}
	
	@PostMapping
	public ResponseEntity<TopicoDto> Insert(@RequestBody TopicoForm tpForm,UriComponentsBuilder uriBuilder) {
		Topico topico = tpForm.converter(cursoRepository);
		System.out.print(topico.getId());
		return ResponseEntity.created(uriBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri()).body(new TopicoDto(topico));
	}
	
	
	
	
	
	
}
