package com.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.ComicDTO;
import com.api.dto.UserDTO;
import com.api.services.ComicService;

@RestController
@RequestMapping(value = "/comic")
public class ComicController {

	@Autowired
	ComicService service;

	
	@PostMapping("/{id}")
	public ResponseEntity<ComicDTO> newComic(@PathVariable Long id, @RequestBody UserDTO user) {
		return service.newComic(id, user);
	}


}
