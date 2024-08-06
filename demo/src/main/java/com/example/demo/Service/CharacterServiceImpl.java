package com.example.demo.Service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.example.demo.model.Characters;
import com.example.demo.repo.CharacterRepo;

@Service
public class CharacterServiceImpl implements CharacterService {
	
	private final CharacterRepo characterRepo;
	
	public CharacterServiceImpl(CharacterRepo characterRepo)  {
		this.characterRepo=characterRepo;
	
	}

	@Override
	public List<Characters> getAll() {
		// TODO Auto-generated method stub
		return characterRepo.findAll();
	}

	@Override
	public Characters getById(int id) {
		return characterRepo.findById(id).orElseThrow(()-> new RuntimeException("Not Found"));
	}

	@Override
	public List<Characters> addCharacter(Characters character) {
		List<Characters> list = characterRepo.findAll();
		
		characterRepo.save(character);
		list.add(character);
		return list;
		
		
	}

	@Override
	public List<Characters> deleteCharacter(int id) {
		
		characterRepo.deleteById(id);          
		List<Characters> list = characterRepo.findAll();
		return list;
		
		
	}

	@Override
	public Characters updateCharacter(Characters character) {
		Characters characters = characterRepo.findById(character.getCharacterId()).orElseThrow(()-> new RuntimeException("Not Found"));
		characters.setCharacterId(character.getCharacterId());
		characters.setDefense(character.getDefense());
		characters.setHitPoints(character.getHitPoints());
		characters.setName(character.getName());
		characters.setStrength(character.getStrength());
	
		
		return character;
	}



}
