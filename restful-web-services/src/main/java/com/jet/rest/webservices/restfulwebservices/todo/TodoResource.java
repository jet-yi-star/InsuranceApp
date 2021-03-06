package com.jet.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

    //Spring container created instance and Injected into this declaration
    @Autowired
    private TodoHardcodedService todoService;

    //in-memory service not JPA/Hibernate service
    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable("username")String username) {
        return todoService.findAll();
    }

//    @DeleteMapping("/users/{username}/todos/{id}")
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("username")String username,
                                           @PathVariable("id")long id) {
        Todo todo = todoService.deleteById(id);
        if (todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable("username")String username,
                        @PathVariable("id")long id) {
        return this.todoService.findById(id);

    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("username")String username,
                           @PathVariable("id")long id,
                           @RequestBody Todo todo) {
        System.out.println("updated " + todo);
        Todo todoUpdated =todoService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(@PathVariable("username")String username,
                                           @RequestBody Todo todo) {

        todo.setUsername(username);
        System.out.println("created " + todo);
        Todo todoCreated =todoService.save(todo);
        //Location
        //Get current resource url
        //append {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(todoCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
