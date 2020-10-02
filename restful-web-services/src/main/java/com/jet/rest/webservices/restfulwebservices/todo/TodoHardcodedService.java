package com.jet.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TodoHardcodedService {
    //act as our database
    private static List<Todo> todos = new ArrayList<Todo>();
    private static long idCounter = 0;
    static {
        todos.add(new Todo(++idCounter, "root", "Learn to Dance",new Date(), false));
        todos.add(new Todo(++idCounter, "root", "Learn about Microservices",new Date(), false));
        todos.add(new Todo(++idCounter, "root", "Learn about Angular",new Date(), false));
    }

    //why this method isn't static
    public List<Todo> findAll() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if (todo == null) {
            return null;
        }
        if (todos.remove(todo)){
            return todo;
        }
        return null;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            //add new
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            //update
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;

    }

}
