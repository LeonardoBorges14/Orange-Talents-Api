package com.api.services;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.dto.UserComicListDTO;
import com.api.dto.UserDTO;
import com.api.repositories.UserRepository;
import com.api.services.exceptions.BadRequestException;
import com.api.services.exceptions.NotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public ResponseEntity<UserDTO> newUser(UserDTO user) {
		try {
			this.repository.save(user.build());
			return ResponseEntity.status(201).body(user);
		} 
		catch (DataIntegrityViolationException e) {
			throw new BadRequestException("Erro de Preenchimento de Dados! O Campo CPF ou Email já foram cadastrados");
		}
		catch (ConstraintViolationException e) {
			throw new BadRequestException("Erro de Preenchimento de Dados! Nenhum campo pode estar em Branco");
		} 
	}
	
	public UserComicListDTO getComicsListByUser(Long id) {
		UserComicListDTO userComicList = repository.UserComicList(id);
		if (userComicList == null) {
			throw new NotFoundException("Não foi encontrado o Usuario com o Id: " + id);
		}
		return userComicList;
	}

}
