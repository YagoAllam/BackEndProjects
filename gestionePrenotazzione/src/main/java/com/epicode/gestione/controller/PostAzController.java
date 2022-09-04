package com.epicode.gestione.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.epicode.gestione.model.PostazioneAziendale;

import com.epicode.gestione.services.PostazioneAziendaleService;


@RestController
@RequestMapping("/edificio")
public class PostAzController {
	
	@Autowired
	PostazioneAziendaleService postService;
	
	
	@PostMapping("/add")
	public void addUtente(@RequestBody PostazioneAziendale ed) {
		
		postService.addPost(ed);
	}
	
	@GetMapping
	public List<PostazioneAziendale > findAll(){
		return postService.findAll();
	}
	
	@GetMapping("/{id}")
	public PostazioneAziendale findById(@PathVariable Long id) {
		return postService.trovaById(id);
	}
	
	

}
