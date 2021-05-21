package br.com.alura.forum.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Curso;

public class CursosDTO {

	private Long id;
	private String nome;
	private String categoria;
	
	public CursosDTO(Curso curso) {
		this.id = curso.getId();
		this.nome = curso.getNome();
		this.categoria = curso.getCategoria();
	}
	
	public static List<CursosDTO> conversor(List<Curso> curso){
		return curso.stream().map(CursosDTO::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
