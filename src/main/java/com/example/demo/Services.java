package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Dto;
import com.example.demo.entity1.Entity1;
import com.example.demo.entity2.Entity2;
import com.example.demo.repo1.Repo1;
import com.example.demo.repo2.Repo2;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Services {
	@Autowired
	Repo1 repo1;
	@Autowired
	Repo2 repo2;
	public void add(Entity1 entity1) {
		Entity2 entity2 = new Entity2();
		entity2.setId(entity1.getId());
		entity2.setName(entity1.getName());
		
		repo1.save(entity1);
		repo2.save(entity2);
	}
	
	public Dto all () {
		Dto dto = new Dto();
		dto.setEntity1s(repo1.findAll());
		dto.setEntity2s(repo2.findAll());
		return dto;
	}
}
