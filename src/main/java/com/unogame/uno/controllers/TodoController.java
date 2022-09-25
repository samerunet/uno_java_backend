package com.unogame.uno.controllers;



import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.unogame.uno.repositories.TodoRepository;
import com.unogame.uno.entities.Todo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TodoController {

    // Property to hold Todo Repository
    public TodoRepository Todos;

    // Receive Todo Repository via Dependency Injection
    public TodoController(TodoRepository Todos){
        this.Todos = Todos;
    }

    // get request to /Todos
    @CrossOrigin // Enable CORS <-
    @GetMapping("/todos")
    public List<Todo> index(){
        return Todos.findAll();
    }

    // get request to /Todos/:id
    @CrossOrigin // Enable CORS <-
    @GetMapping("/todos/{id}")
    public Optional<Todo> show(@PathVariable Integer id){
        return Todos.findById(id);
    }

    @CrossOrigin // Enable CORS <-
    @PostMapping("/todos")
    public List<Todo> create(@RequestBody Todo newTodo){
        Todos.save(newTodo); // Create the New Todo
        return Todos.findAll();
    }

    @CrossOrigin // Enable CORS <-
    @PutMapping("/todos/{id}")
    public List<Todo> update(@RequestBody Todo fixTodo, @PathVariable Integer id){
        // Find Todo by it's then use map to update it
        Todos.findById(id).map(Todo -> {

        Todo.setUsername(fixTodo.getUsername());
        Todo.setName(fixTodo.getName());
        Todo.setLogo(fixTodo.getLogo());
        Todo.setScore(fixTodo.getScore());
        Todo.setFriends(fixTodo.getFriends());
        Todo.setInventory(fixTodo.getInventory());
        Todos.save(Todo);
        return Todo;

        });

        // return all Todos
        return Todos.findAll();
    }

    @CrossOrigin // Enable CORS <-
    @DeleteMapping("/todos/{id}")
    public List<Todo> destroy(@PathVariable Integer id){
        Todos.deleteById(id);
        return Todos.findAll();
    }

}
