package com.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table(name="comic")
public class Comic implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo titulo não pode estar em branco")	
	@Column( nullable = false ) 
	private String titulo;
	
	@NotNull
	@Column( nullable = false ) 
	private double preco;
	
	@NotBlank(message = "O campo autores não pode estar em branco")	
	@Lob
	@Column( nullable = false ) 
	private String autores;
	
	@NotBlank(message = "O campo ISBN não pode estar em branco")	
	@Column( nullable = false ) 
	private String ISBN;
	
	@NotBlank(message = "O campo descrição não pode estar em branco")	
	@Lob
	@Column( nullable = false ) 
	private String descricao;
	
	@ManyToOne
	private User user;
	

	public Comic(Long id, String titulo, double preco, String autores, String ISBN, String descricao, User user) {
		this.id = id;
		this.titulo = titulo;
		this.preco = preco;
		this.autores = autores;
		this.ISBN = ISBN;
		this.descricao = descricao;
		this.user = user;
	}


	public Comic() {

	}
	

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
	

	public void setUser(User user) {
		this.user = user;
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
		Comic other = (Comic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
