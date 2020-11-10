package com.mehmetpekldemir.tdd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekldemir.tdd.dto.request.TodoRequest;
import com.mehmetpekldemir.tdd.dto.response.TodoResponse;
import com.mehmetpekldemir.tdd.service.TodoService;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor // Constructor injection with lombok
public class TodoController {

	private final TodoService todoService;

	@GetMapping("todo")
	public ResponseEntity<List<TodoResponse>> getAllTodos() {
		final var response = todoService.getAllTodos();
		return ResponseEntity.ok(response);
	}

	@PostMapping("todo")
	public ResponseEntity<?> createTodo(@Valid TodoRequest todoRequest) {
		final var response = todoService.createTodo(todoRequest);
		return ResponseEntity.ok(response);
	}
	
}
