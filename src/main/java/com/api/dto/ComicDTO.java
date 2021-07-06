package com.api.dto;

import java.io.Serializable;


import com.api.entities.Comic;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ComicDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Long id;
	private String titulo;
	private double preco;
	private String autores;
	private String ISBN;
	private String descricao;

	private UserDTO user;


	public ComicDTO(Long id, String titulo, double preco, String autores, String ISBN, String descricao, UserDTO user) {
		this.id = id;
		this.titulo = titulo;
		this.preco = preco;
		this.autores = autores;
		this.ISBN = ISBN;
		this.descricao = descricao;
		this.user = user;
	}

	public ComicDTO() {

	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	

	public Comic build() {
		Comic comic = new Comic();

		comic.setId(this.id);
		comic.setTitulo(this.titulo);
		comic.setPreco(this.preco);
		comic.setAutores(this.autores);
		comic.setISBN(this.ISBN);
		comic.setDescricao(this.descricao);
		comic.setUser(this.user.build());

		return comic;
	}
	
	public ComicDTO(Comic comic) {
		this.id = comic.getId();
		this.titulo = comic.getTitulo();
		this.preco = comic.getPreco();
		this.autores = comic.getAutores();
		this.ISBN = comic.getISBN();
		this.descricao = comic.getDescricao();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComicDTO other = (ComicDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
