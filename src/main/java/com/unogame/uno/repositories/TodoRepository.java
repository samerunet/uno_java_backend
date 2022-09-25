package com.unogame.uno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unogame.uno.entities.Todo;

// Our Repository, the two types in <> are the Entity and type of the ID
public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
