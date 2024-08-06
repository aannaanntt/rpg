package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Characters;


public interface CharacterService {

	List<Characters> getAll();
	
	Characters getById(int id);
	List<Characters> addCharacter(Characters character);
	List<Characters> deleteCharacter(int id);
	
	Characters updateCharacter(Characters character);
	
}
