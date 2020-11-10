package com.mehmetpekldemir.tdd.service;

import java.util.List;

import com.mehmetpekldemir.tdd.dto.request.TodoRequest;
import com.mehmetpekldemir.tdd.dto.response.TodoResponse;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface TodoService {

	List<TodoResponse> getAllTodos();

	TodoResponse createTodo(TodoRequest todoRequest);

}
