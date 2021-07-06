package com.api.dto;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.api.entities.Comic;
import com.api.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserComicListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;
	
	@JsonIgnore
	private String diaDesconto;
	
	@JsonIgnore
	private boolean descontoAtivo;

	
	private List<Comic> comics = new ArrayList<>();
	

	public UserComicListDTO(User user) {
		this.id = user.getId();
		this.nome = user.getNome();
		this.email = user.getEmail();
		this.cpf = user.getCPF();
		this.dataNascimento = user.getDataNascimento();
		this.comics = user.getComics();
		for(int i = 0; i < this.comics.size(); i++) {
			int finalDigit = this.comics.get(i).getISBN().charAt(this.comics.get(i).getISBN().length()-1);
			this.setDiaDesconto(diaDesconto, finalDigit);
			String dia = this.getDiaDesconto();
			this.setDescontoAtivo(descontoAtivo, dia);
			if(this.isDescontoAtivo()) 
				this.comics.get(i).setPreco(this.comics.get(i).getPreco()*0.9);
		}

	}


	public UserComicListDTO() {

	}

	public UserComicListDTO(Long id, String nome, String email, String cpf, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

	public List<Comic> getComics() {
		return comics;
	}


	public void setComics(List<Comic> comics) {
		this.comics = comics;
	}

	
	@JsonIgnore
	public String getDiaDesconto() {
		return diaDesconto;
	}

	public void setDiaDesconto(String diaDesconto, int finalDigit) {
		if (finalDigit == '0' || finalDigit == '1')
			this.diaDesconto = "MONDAY";
		else if (finalDigit == '2' || finalDigit == '3')
			this.diaDesconto = "TUESDAY";
		else if (finalDigit == '4' || finalDigit == '5')
			this.diaDesconto = "WEDNESDAY";
		else if (finalDigit == '6' || finalDigit == '7')
			this.diaDesconto = "THURSDAY";
		else if (finalDigit == '8' || finalDigit == '9')
			this.diaDesconto = "FRIDAY";
	}
	
	@JsonIgnore
	public boolean isDescontoAtivo() {
		return descontoAtivo;
	}

	public void setDescontoAtivo(boolean descontoAtivo, String dia) {
		LocalDate localDate = LocalDate.now();
		DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
		if(dayOfWeek.toString() == dia) 
			this.descontoAtivo = true;
		else this.descontoAtivo = false;
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
		UserComicListDTO other = (UserComicListDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
