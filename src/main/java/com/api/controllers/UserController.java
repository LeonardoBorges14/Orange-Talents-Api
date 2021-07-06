package com.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.UserComicListDTO;
import com.api.dto.UserDTO;
import com.api.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService service;

	
	@PostMapping
	public ResponseEntity<UserDTO> newUser(@RequestBody UserDTO user) {
		return service.newUser(user); 
	}
	
	@GetMapping("/{id}")
	public UserComicListDTO getComicsListByUser(@PathVariable Long id) {
		return service.getComicsListByUser(id);
	}

}
