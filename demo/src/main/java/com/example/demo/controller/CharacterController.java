package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CharacterService;
import com.example.demo.model.Characters;
import com.example.demo.repo.CharacterRepo;

@RestController
@RequestMapping(name = "characters")
public class CharacterController {
	
	private final CharacterService service;
	
	public CharacterController(CharacterService characterService) {
		this.service=characterService;
		
	}
	
	@GetMapping("name")
	public String getName() {
		return "Hi";
	}
	
	@GetMapping("/getAll")
	public List<Characters> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/save")
	public  List<Characters> save(@RequestBody  Characters characters) {
		return service.addCharacter(characters);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Characters> delete(@PathVariable Integer id){
		return service.deleteCharacter(id);
		
	}
	
	@PutMapping("/update")
	public Characters update(@RequestBody Characters characters) {
		return service.updateCharacter(characters);
	}

}
