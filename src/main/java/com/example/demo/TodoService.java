package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private final TodoRepository todoRepository;
	
	@Autowired
	public  TodoService (TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}
	
	public Todo getTodoById(Long id) {
		return todoRepository.findById(id).orElse(null);
	}
	
	public Todo createTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public Todo updateTodo(Long id, Todo todo) {
		todo.setId(id);
		return todoRepository.save(todo);
	}
	
	public void deleteTodo(Long id) {
		todoRepository.deleteById(id);
	}

}
