package com.example.demo.conroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services;
import com.example.demo.dto.Dto;
import com.example.demo.entity1.Entity1;

@RestController
public class TwoDbController {
	@Autowired
	Services service;
	
	@PostMapping("/add")
	public ResponseEntity<String> add (@RequestBody Entity1 entity1){
		service.add(entity1);
		return new ResponseEntity<>("Added",HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<Dto> all (){
		return new ResponseEntity<Dto>(service.all(),HttpStatus.OK);
	}
}
