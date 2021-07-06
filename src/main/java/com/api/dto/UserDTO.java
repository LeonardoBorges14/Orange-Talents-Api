package com.api.dto;

import java.io.Serializable;
import java.time.LocalDate;
import com.api.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;


	public UserDTO() {

	}

	public UserDTO(Long id, String nome, String email, String cpf, LocalDate dataNascimento) {
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
	


	public User build() {
		User user = new User();
		
		user.setId(this.id);
		user.setNome(this.nome);
		user.setEmail(this.email);
		user.setCPF(this.cpf);
		user.setDataNascimento(this.dataNascimento);
		return user;
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
		UserDTO other = (UserDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
