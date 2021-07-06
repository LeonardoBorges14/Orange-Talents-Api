package com.api.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.dto.ComicDTO;
import com.api.dto.UserDTO;
import com.api.endpoints.ComicEndpoint;
import com.api.repositories.ComicRepository;
import com.api.services.exceptions.BadRequestException;

import feign.FeignException;

@Service
public class ComicService {

	@Autowired
	ComicRepository repository;

	@Autowired
	ComicEndpoint endpoint;

	public ResponseEntity<ComicDTO> newComic(Long id, UserDTO user) {
		try {

			ComicDTO comic = new ComicDTO();

			// Get Comic
			Object objComic = endpoint.getComic(id);
			Map MapComic = (Map) objComic;

			// Get Comic data
			Object objData = MapComic.get("data");
			Map MapData = (Map) objData;

			// Get data Results
			ArrayList resultsArray = (ArrayList) MapData.get("results");
			Object resultsObj = resultsArray.get(0);
			LinkedHashMap resultsMap = (LinkedHashMap) resultsObj;

			// Get results prices
			ArrayList pricesArray = (ArrayList) resultsMap.get("prices");
			Object pricesObj = pricesArray.get(0);
			LinkedHashMap pricesMap = (LinkedHashMap) pricesObj;

			comic.setTitulo(resultsMap.get("title").toString());
			comic.setPreco(Double.parseDouble(pricesMap.get("price").toString()));
			comic.setAutores(resultsMap.get("creators").toString());
			comic.setDescricao(resultsMap.get("description").toString());
			comic.setISBN(resultsMap.get("isbn").toString());
			comic.setUser(user);

			repository.save(comic.build());
			return ResponseEntity.status(201).body(comic);

		} catch (ConstraintViolationException e) {
			throw new BadRequestException(
					"Erro de Preenchimento de Dados! O comic de id " + id + " não pode ter nenhum campo nulo");
		} catch (FeignException e) {
			throw new BadRequestException("Erro! O comic de id " + id + " não foi encontrado");
		} catch (DataIntegrityViolationException e) {
			throw new BadRequestException("Erro! Não foi encontrado o Usuario com o Id digitado");
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("Erro! É necessário preencher o Id do usuário proprietário do Comic");
		}
	}
}
