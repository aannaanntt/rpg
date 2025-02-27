package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Characters;


@Repository
public interface CharacterRepo extends JpaRepository<Characters, Integer>{

}
